package com.zm.media.ibs.program.controller;

import com.zm.media.core.base.controller.BaseController;
import com.zm.media.core.base.dto.RespMsg;
import com.zm.media.core.base.dto.RespMsgKit;
import com.zm.media.ibs.program.entity.Program;
import com.zm.media.ibs.program.entity.vo.ProgramVO;
import com.zm.media.ibs.program.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USERA on 2019/2/15.
 * 主题相关接口
 */
@RestController
@RequestMapping("/v1/api/programs")
public class ProgramController extends BaseController {

    @Autowired
    private ProgramService programService;

    /**
     * 创建主题
     * @param programVO
     * @return
     */
    @PostMapping
    public RespMsg createProgram(@RequestBody ProgramVO programVO){
        programService.addProgram(programVO);
        return RespMsgKit.buildSuccessRespMsg();
    }

    /**
     * 根据id获取主题
     * @param programId
     * @return
     */
    @GetMapping("/{programId}/program")
    public RespMsg getProgramByProgramId(@PathVariable Long programId){
        Program program = programService.getById(programId);
        return RespMsgKit.buildSuccessRespMsg(program);
    }

    /**
     * 根据id获取主题
     * @param programId
     * @return
     */
    @GetMapping("/{programId}/programDetail")
    public RespMsg getDetailByProgramId(@PathVariable Long programId){
        ProgramVO program = programService.getDetailById(programId);
        return RespMsgKit.buildSuccessRespMsg(program);
    }

    /**
     * 根据公司获取公司主题
     * @param corpId
     * @return
     */
    @GetMapping("/{corpId}/programList")
    public RespMsg getProgramByCorpId(@PathVariable Long corpId){
        List<Program> programList = programService.getByCorpId(corpId);
        if(programList == null){
            programList = new ArrayList<>();
        }
        return RespMsgKit.buildSuccessRespMsg(programList);
    }


}
