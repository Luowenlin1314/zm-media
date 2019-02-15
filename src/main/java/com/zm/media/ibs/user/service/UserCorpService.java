package com.zm.media.ibs.user.service;

import com.zm.media.ibs.user.entity.UserCorp;

/**
 * Created by USERA on 2019/2/14.
 */
public interface UserCorpService {

    /**
     * 添加公司-用户关联
     * @param userCorp
     * @return
     */
    int addUserCorp(UserCorp userCorp);

    /**
     * 移除公司-用户关联
     * @param userCorp
     * @return
     */
    int removeUserCorp(UserCorp userCorp);


}
