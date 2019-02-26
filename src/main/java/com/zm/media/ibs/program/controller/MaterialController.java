package com.zm.media.ibs.program.controller;

import com.zm.media.core.base.controller.BaseController;
import com.zm.media.core.base.dto.RespMsg;
import com.zm.media.core.base.dto.RespMsgKit;
import com.zm.media.ibs.program.entity.Material;
import com.zm.media.ibs.program.entity.vo.MaterialVO;
import com.zm.media.ibs.program.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by USERA on 2019/2/15.
 */
@RestController
@RequestMapping("/v1/api/materials")
public class MaterialController extends BaseController{

    @Autowired
    private MaterialService materialService;

    @PostMapping
    public RespMsg uploadMaterial(@RequestBody MaterialVO materialVO,
                                  @RequestParam(value = "file", required = true) MultipartFile materialFile){
        String tempPath = request.getSession().getServletContext().getRealPath("/");
        materialVO.setTempPath(tempPath);
        int result = materialService.uploadMaterial(materialVO,materialFile);
        if(result > 0){
            return RespMsgKit.buildSuccessRespMsg();
        }
        return RespMsgKit.buildFailedRespMsg();
    }


    @GetMapping("/corp/{corpId}/materials")
    public RespMsg getMaterial(@PathVariable Long corpId){
        List<Material> materialList = materialService.getByCorpId(corpId);
        return RespMsgKit.buildSuccessRespMsg(materialList);
    }

}
