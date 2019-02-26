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
import com.zm.media.ibs.user.service.CorpService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by USERA on 2019/2/14.
 */
@Component
public class TerminalIdentityHandler extends BaseHandler{

    @Autowired
    private CorpService corpService;
    @Autowired
    private DeviceService deviceService;
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
            addTerminal(device.getDeviceId(),ctx);
            BasePro result = new BasePro();
            result.setName(ProtocolCons.TERMINAL_IDENTITY_SUCCESS);
            result.setData("success");
            ByteBuf msg = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(result.toJson(), CharsetUtil.UTF_8));
            ctx.writeAndFlush(msg.duplicate()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            return;
        }

        //首次连接,查找公司
        String corpCode = identity.getCorpCode();
        Corp corp = corpService.getByCode(corpCode);
        if(corp == null){
            BasePro result = new BasePro();
            result.setName(ProtocolCons.TERMINAL_IDENTITY_FAIL);
            result.setData("fail");
            ByteBuf msg = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(result.toJson(), CharsetUtil.UTF_8));
            ctx.writeAndFlush(msg.duplicate()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            return;
        }

        //添加设备
        device = new Device();
        BeanUtils.copyProperties(identity,device);
        device.setCreateTime(new Date());
        device.setDeviceId(idWorker.nextId());
        deviceService.addDevice(device);

        //公司添加设备
        DeviceCorp deviceCorp = new DeviceCorp();
        deviceCorp.setCorpId(corp.getCorpId());
        deviceCorp.setCreateTime(new Date());
        deviceCorp.setDeviceId(device.getDeviceId());
        deviceCorpService.addDeviceCorp(deviceCorp);

        addTerminal(device.getDeviceId(),ctx);
        BasePro result = new BasePro();
        result.setName(ProtocolCons.TERMINAL_IDENTITY_SUCCESS);
        result.setData("success");
        ByteBuf msg = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(result.toJson(), CharsetUtil.UTF_8));
        ctx.writeAndFlush(msg.duplicate()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
    }

    private void addTerminal(Long deviceId, ChannelHandlerContext ctx){
        TerminalContainer.addTerminal(deviceId, ctx);
        logger.info("终端连接：" + deviceId + "，当前在线终端数量：" + TerminalContainer.getTerminalSize());
    }

}
