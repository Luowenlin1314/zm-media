package com.zm.media.ibs.user.persistence;

import com.zm.media.ibs.user.entity.UserCorp;
import com.zm.media.ibs.user.entity.UserCorpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCorpMapper {
    int countByExample(UserCorpExample example);

    int deleteByExample(UserCorpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserCorp record);

    int insertSelective(UserCorp record);

    List<UserCorp> selectByExample(UserCorpExample example);

    UserCorp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserCorp record, @Param("example") UserCorpExample example);

    int updateByExample(@Param("record") UserCorp record, @Param("example") UserCorpExample example);

    int updateByPrimaryKeySelective(UserCorp record);

    int updateByPrimaryKey(UserCorp record);
}