package com.zm.media.ibs.user.controller;

import com.zm.media.core.base.controller.BaseController;
import com.zm.media.core.base.dto.RespMsg;
import com.zm.media.core.base.dto.RespMsgKit;
import com.zm.media.ibs.user.entity.Corp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by USERA on 2019/2/13.
 * 公司相关接口
 */
@RestController
@RequestMapping("/v1/api/corp")
public class CorpController extends BaseController {

    /**
     *  创建公司
     * @param corp
     * @return
     */
    @PostMapping
    public RespMsg createCorp(@RequestBody Corp corp){

        return RespMsgKit.buildSuccessRespMsg();
    }



}
