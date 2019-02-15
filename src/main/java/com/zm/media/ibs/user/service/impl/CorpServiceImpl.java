package com.zm.media.ibs.user.service.impl;

import com.zm.media.ibs.user.entity.Corp;
import com.zm.media.ibs.user.entity.CorpExample;
import com.zm.media.ibs.user.entity.UserCorp;
import com.zm.media.ibs.user.persistence.CorpMapper;
import com.zm.media.ibs.user.persistence.UserCorpMapper;
import com.zm.media.ibs.user.service.CorpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by USERA on 2019/2/14.
 */
@Service
public class CorpServiceImpl implements CorpService {

    @Resource
    private CorpMapper corpMapper;
    @Resource
    private UserCorpMapper userCorpMapper;


    @Override
    public int addCorp(Corp corp) {
        // 创建公司
        corp.setCorpCode(randomCorpCode());
        corpMapper.insertSelective(corp);

        //添加公司关联
        UserCorp userCorp = new UserCorp();
        userCorp.setUserId(corp.getCreateBy());
        userCorp.setCorpId(corp.getCorpId());
        userCorp.setCreateBy(corp.getCreateBy());
        userCorp.setCreateTime(new Date());
        userCorpMapper.insertSelective(userCorp);

        return corpMapper.insertSelective(corp);
    }

    @Override
    public int removeCorp(String corpId) {
        return 0;
    }

    @Override
    public Corp getById(String corpId) {
        return null;
    }

    @Override
    public Corp getByCode(String corpCode) {
        CorpExample corpExample = new CorpExample();
        corpExample.or().andCorpCodeEqualTo(corpCode);
        List<Corp> corpList = corpMapper.selectByExample(corpExample);
        if(corpList != null && corpList.size() > 0){
            return corpList.get(0);
        }
        return null;
    }

    /**
     *  随机生成不重复4位公司邀请码
     * @return
     */
    private String randomCorpCode(){
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        String number = sb.toString();
        CorpExample example = new CorpExample();
        example.or().andCorpCodeEqualTo(number);
        List<Corp> corpList = corpMapper.selectByExample(example);
        if(corpList != null && corpList.size() > 0){
            return randomCorpCode();
        }
        return number;
    }

}
