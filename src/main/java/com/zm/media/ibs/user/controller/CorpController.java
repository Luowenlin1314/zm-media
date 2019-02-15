package com.zm.media.ibs.user.controller;

import com.zm.media.core.base.controller.BaseController;
import com.zm.media.core.base.dto.RespMsg;
import com.zm.media.core.base.dto.RespMsgKit;
import com.zm.media.ibs.user.entity.Corp;
import com.zm.media.ibs.user.entity.UserCorp;
import com.zm.media.ibs.user.service.CorpService;
import com.zm.media.ibs.user.service.UserCorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * Created by USERA on 2019/2/13.
 * 公司相关接口
 */
@RestController
@RequestMapping("/v1/api/corps")
public class CorpController extends BaseController {

    @Autowired
    private CorpService corpService;
    @Autowired
    private UserCorpService userCorpService;

    /**
     *  创建公司
     * @param corp
     * @return
     */
    @PostMapping
    public RespMsg createCorp(@RequestBody Corp corp){
        corp.setCreateTime(new Date());
        corpService.addCorp(corp);
        return RespMsgKit.buildSuccessRespMsg();
    }

    /**
     * 加入公司
     * @param userCorp
     * @return
     */
    @PostMapping
    @RequestMapping("/join")
    public RespMsg joinCorp(@RequestBody UserCorp userCorp){
        userCorp.setCreateTime(new Date());
        userCorpService.addUserCorp(userCorp);
        return RespMsgKit.buildSuccessRespMsg();
    }

}
