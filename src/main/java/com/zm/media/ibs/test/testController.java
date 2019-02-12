package com.zm.media.ibs.test;

import com.zm.media.core.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by USERA on 2019/2/11.
 */
@RestController
public class testController {

    @Autowired
    private RedisService redisService;

    @GetMapping("test")
    public String remindManager() {
        boolean flag = redisService.exists("test212");
        if(flag){
            return "success";
        }
        return "false";
    }

}
