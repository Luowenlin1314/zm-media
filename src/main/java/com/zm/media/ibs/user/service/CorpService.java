package com.zm.media.ibs.user.service;

import com.zm.media.ibs.user.entity.Corp;

/**
 * Created by USERA on 2019/2/14.
 * 公司相关
 */
public interface CorpService {

    /**
     * 创建公司
     * @param corp
     * @return
     */
    int addCorp(Corp corp);

    /**
     * 解散公司
     * @param corpId
     * @return
     */
    int removeCorp(String corpId);

    /**
     * 根据公司id获取
     * @param corpId
     * @return
     */
    Corp getById(String corpId);

    /**
     * 根据公司id获取
     * @param corpCode
     * @return
     */
    Corp getByCode(String corpCode);

}
