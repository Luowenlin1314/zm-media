package com.zm.media.ibs.user.service.impl;

import com.zm.media.ibs.user.entity.UserCorp;
import com.zm.media.ibs.user.entity.UserCorpExample;
import com.zm.media.ibs.user.persistence.UserCorpMapper;
import com.zm.media.ibs.user.service.UserCorpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by USERA on 2019/2/14.
 */
@Service
public class UserCorpServiceImpl implements UserCorpService {

    @Resource
    private UserCorpMapper userCorpMapper;

    @Override
    public int addUserCorp(UserCorp userCorp) {
        return userCorpMapper.insertSelective(userCorp);
    }

    @Override
    public int removeUserCorp(UserCorp userCorp) {
        UserCorpExample userCorpExample = new UserCorpExample();
        userCorpExample.or().andUserIdEqualTo(userCorp.getUserId()).andCorpIdEqualTo(userCorp.getCorpId());
        return userCorpMapper.deleteByExample(userCorpExample);
    }
}
