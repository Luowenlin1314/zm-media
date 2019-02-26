package com.zm.media.ibs.program.controller;

import com.zm.media.common.util.JacksonUtils;
import com.zm.media.core.base.controller.BaseController;
import com.zm.media.core.base.dto.RespMsg;
import com.zm.media.core.base.dto.RespMsgKit;
import com.zm.media.ibs.netty.handler.transfer.TransferHandler;
import com.zm.media.ibs.program.entity.Program;
import com.zm.media.ibs.program.entity.vo.ProgramVO;
import com.zm.media.ibs.program.service.ProgramService;
import com.zm.media.ibs.protocol.base.BasePro;
import com.zm.media.ibs.protocol.constant.ProtocolCons;
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
    @Autowired
    private TransferHandler transferHandler;

    /**
     * 下发主题
     * @param deviceId
     * @return
     */
    @GetMapping("/device/{deviceId}/program/{programId}")
    public RespMsg sendProgram(@PathVariable Long deviceId,@PathVariable Long programId){
        ProgramVO programVO = programService.getDetailById(programId);
        BasePro basePro = new BasePro();
        basePro.setName(ProtocolCons.PROGRAM_UPDATE);
        basePro.setData(programVO);
        transferHandler.sendMessage(deviceId, JacksonUtils.pojo2Json(basePro));
        return RespMsgKit.buildSuccessRespMsg();
    }

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
    @GetMapping("/{programId}")
    public RespMsg getProgramByProgramId(@PathVariable Long programId){
        Program program = programService.getById(programId);
        return RespMsgKit.buildSuccessRespMsg(program);
    }

    /**
     * 根据id获取主题
     * @param programId
     * @return
     */
    @GetMapping("/{programId}/detail")
    public RespMsg getDetailByProgramId(@PathVariable Long programId){
        ProgramVO program = programService.getDetailById(programId);
        return RespMsgKit.buildSuccessRespMsg(program);
    }

    /**
     * 根据公司获取公司主题
     * @param corpId
     * @return
     */
    @GetMapping("/corp/{corpId}/programs")
    public RespMsg getProgramByCorpId(@PathVariable Long corpId){
        List<Program> programList = programService.getByCorpId(corpId);
        if(programList == null){
            programList = new ArrayList<>();
        }
        return RespMsgKit.buildSuccessRespMsg(programList);
    }


}
