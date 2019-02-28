package com.zm.media.ibs.wechat.controller;

import com.zm.media.core.base.controller.BaseController;
import com.zm.media.core.base.dto.RespMsg;
import com.zm.media.core.base.dto.RespMsgKit;
import com.zm.media.ibs.wechat.entity.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by USERA on 2019/2/28.
 */
@RestController
@RequestMapping("v1/api/wechat")
public class WechatController extends BaseController {

    @PostMapping("/bind")
    public RespMsg wechatBind(@RequestBody UserInfo userInfo){

        return RespMsgKit.buildSuccessRespMsg();
    }

    @PostMapping("/login")
    public RespMsg wechatLogin(@RequestBody UserInfo userInfo){

        return RespMsgKit.buildSuccessRespMsg();
    }

}
