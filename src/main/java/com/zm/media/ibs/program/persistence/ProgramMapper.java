package com.zm.media.ibs.program.persistence;

import com.zm.media.ibs.program.entity.Program;
import com.zm.media.ibs.program.entity.ProgramExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProgramMapper {
    int countByExample(ProgramExample example);

    int deleteByExample(ProgramExample example);

    int deleteByPrimaryKey(Long programId);

    int insert(Program record);

    int insertSelective(Program record);

    List<Program> selectByExample(ProgramExample example);

    Program selectByPrimaryKey(Long programId);

    int updateByExampleSelective(@Param("record") Program record, @Param("example") ProgramExample example);

    int updateByExample(@Param("record") Program record, @Param("example") ProgramExample example);

    int updateByPrimaryKeySelective(Program record);

    int updateByPrimaryKey(Program record);
}