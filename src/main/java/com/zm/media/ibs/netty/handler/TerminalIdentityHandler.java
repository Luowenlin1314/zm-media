package com.zm.media.ibs.netty.handler;

import com.zm.media.common.util.JacksonUtils;
import com.zm.media.common.util.SnowflakeIdWorker;
import com.zm.media.ibs.device.entity.Device;
import com.zm.media.ibs.device.entity.DeviceCorp;
import com.zm.media.ibs.device.service.DeviceCorpService;
import com.zm.media.ibs.device.service.DeviceService;
import com.zm.media.ibs.netty.handler.base.BaseHandler;
import com.zm.media.ibs.netty.handler.container.TerminalContainer;
import com.zm.media.ibs.protocol.base.BasePro;
import com.zm.media.ibs.protocol.constant.ProtocolCons;
import com.zm.media.ibs.protocol.entity.Identity;
import com.zm.media.ibs.user.entity.Corp;
import com.zm.media.ibs.user.entity.UserDevice;
import com.zm.media.ibs.user.entity.UserDeviceExample;
import com.zm.media.ibs.user.persistence.UserDeviceMapper;
import com.zm.media.ibs.user.service.CorpService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by USERA on 2019/2/14.
 */
@Component
public class TerminalIdentityHandler extends BaseHandler{

    @Autowired
    private CorpService corpService;
    @Autowired
    private DeviceService deviceService;
    @Resource
    private UserDeviceMapper userDeviceMapper;
    @Autowired
    private DeviceCorpService deviceCorpService;
    private SnowflakeIdWorker idWorker = new SnowflakeIdWorker();

    @Override
    public void handler(ChannelHandlerContext ctx, BasePro basePro) {
        String json = JacksonUtils.pojo2Json(basePro.getData());
        Identity identity = JacksonUtils.json2Pojo(json,Identity.class);

        //查找设备
        Device device = deviceService.getByDeviceCode(identity.getDeviceCode());
        if(device != null){
            //TODO 时间判断
            addTerminal(device.getDeviceId(),ctx);
            ctx.writeAndFlush(buildFailConnect(ProtocolCons.TERMINAL_IDENTITY_SUCCESS,"success").duplicate()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            return;
        }

        //首次连接,查找公司
        String corpCode = identity.getCorpCode();
        Corp corp = corpService.getByCode(corpCode);
        if(corp == null){
            ctx.writeAndFlush(buildFailConnect(ProtocolCons.TERMINAL_IDENTITY_FAIL,"fail").duplicate()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            return;
        }

        //查找公司剩余终端数量
        UserDeviceExample userDeviceExample = new UserDeviceExample();
        userDeviceExample.or().andCopidEqualTo(corp.getCorpId());
        List<UserDevice> userDeviceList = userDeviceMapper.selectByExample(userDeviceExample);
        UserDevice validUserDevice = null;
        if(userDeviceList == null || userDeviceList.size() == 0){
            ctx.writeAndFlush(buildFailConnect(ProtocolCons.TERMINAL_IDENTITY_FAIL,"fail").duplicate()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            return;
        }
        for (UserDevice userDevice : userDeviceList) {
            if((userDevice.getTotalcount() - userDevice.getUsecount()) > 0){
                validUserDevice= userDevice;
                break;
            }
        }

        if(validUserDevice == null){
            ctx.writeAndFlush(buildFailConnect(ProtocolCons.TERMINAL_IDENTITY_FAIL,"fail").duplicate()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            return;
        }

        //添加设备
        device = new Device();
        BeanUtils.copyProperties(identity,device);
        device.setCreateTime(new Date());
        device.setDeviceId(idWorker.nextId());
        device.setStartTime(validUserDevice.getStartTime());
        device.setEndTime(validUserDevice.getEndTime());
        deviceService.addDevice(device);

        //公司添加设备
        DeviceCorp deviceCorp = new DeviceCorp();
        deviceCorp.setCorpId(corp.getCorpId());
        deviceCorp.setCreateTime(new Date());
        deviceCorp.setDeviceId(device.getDeviceId());
        deviceCorpService.addDeviceCorp(deviceCorp);

        //数量加1
        validUserDevice.setUsecount(validUserDevice.getUsecount() + 1);
        userDeviceMapper.updateByPrimaryKey(validUserDevice);

        addTerminal(device.getDeviceId(),ctx);
        ctx.writeAndFlush(buildFailConnect(ProtocolCons.TERMINAL_IDENTITY_SUCCESS,"success").duplicate()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
    }

    private void addTerminal(Long deviceId, ChannelHandlerContext ctx){
        TerminalContainer.addTerminal(deviceId, ctx);
        logger.info("终端连接：" + deviceId + "，当前在线终端数量：" + TerminalContainer.getTerminalSize());
    }

    private ByteBuf buildFailConnect(Integer name,String error){
        BasePro result = new BasePro();
        result.setName(ProtocolCons.TERMINAL_IDENTITY_FAIL);
        result.setData("fail");
        ByteBuf msg = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(result.toJson(), CharsetUtil.UTF_8));
        return msg;
    }
}
