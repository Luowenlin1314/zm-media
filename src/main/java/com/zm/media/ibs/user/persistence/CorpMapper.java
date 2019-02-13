package com.zm.media.ibs.user.persistence;

import com.zm.media.ibs.user.entity.Corp;
import com.zm.media.ibs.user.entity.CorpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CorpMapper {
    int countByExample(CorpExample example);

    int deleteByExample(CorpExample example);

    int deleteByPrimaryKey(String corpId);

    int insert(Corp record);

    int insertSelective(Corp record);

    List<Corp> selectByExample(CorpExample example);

    Corp selectByPrimaryKey(String corpId);

    int updateByExampleSelective(@Param("record") Corp record, @Param("example") CorpExample example);

    int updateByExample(@Param("record") Corp record, @Param("example") CorpExample example);

    int updateByPrimaryKeySelective(Corp record);

    int updateByPrimaryKey(Corp record);
}