package com.zm.media.ibs.program.service;

import com.zm.media.ibs.program.entity.Material;
import com.zm.media.ibs.program.entity.vo.MaterialVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by USERA on 2019/2/18.
 */
public interface MaterialService {

    /**
     * 上传元素
     * @param materialVO
     * @param materialFile
     * @return
     */
    int uploadMaterial(MaterialVO materialVO, MultipartFile materialFile);

    /**
     * 根据公司id
     * @param corpId
     * @return
     */
    List<Material> getByCorpId(Long corpId);

    /**
     * 根据公司id和元素md5获取
     * @param corpId
     * @param md5
     * @return
     */
    Material getByCorpIdAndMd5(Long corpId,String md5);

}
