package com.zm.media.ibs.user.controller;

import com.zm.media.core.base.controller.BaseController;
import com.zm.media.core.base.dto.RespMsg;
import com.zm.media.core.base.dto.RespMsgKit;
import com.zm.media.ibs.user.entity.UserDevice;
import com.zm.media.ibs.user.persistence.UserDeviceMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by USERA on 2019/2/28.
 */
@RestController
@RequestMapping("/v1/api/userDevices")
public class UserDeviceController extends BaseController {

    @Resource
    private UserDeviceMapper userDeviceMapper;

    @PostMapping("/buy")
    public RespMsg buyTerminal(@RequestBody UserDevice userDevice){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, 1);
        userDevice.setCreateTime(new Date());
        userDevice.setStartTime(new Date());
        userDevice.setEndTime(date);
        userDevice.setUsecount(0);
        userDeviceMapper.insertSelective(userDevice);
        return RespMsgKit.buildSuccessRespMsg();
    }

}
