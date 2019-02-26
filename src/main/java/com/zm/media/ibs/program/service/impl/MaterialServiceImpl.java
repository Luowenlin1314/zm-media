package com.zm.media.ibs.program.service.impl;

import com.zm.media.common.util.Md5Util;
import com.zm.media.ibs.program.entity.Material;
import com.zm.media.ibs.program.entity.MaterialExample;
import com.zm.media.ibs.program.entity.vo.MaterialVO;
import com.zm.media.ibs.program.persistence.MaterialMapper;
import com.zm.media.ibs.program.pool.MaterialThreadPool;
import com.zm.media.ibs.program.pool.thread.MaterialThread;
import com.zm.media.ibs.program.service.MaterialService;
import com.zm.media.ibs.resources.util.FileUtil;
import com.zm.media.ibs.resources.util.FtpFileUtil;
import com.zm.media.ibs.user.entity.User;
import com.zm.media.ibs.user.persistence.UserMapper;
import com.zm.media.spring.data.FtpProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USERA on 2019/2/18.
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private MaterialMapper materialMapper;
    @Autowired
    private FtpProps ftpProps;

    @Override
    public int uploadMaterial(MaterialVO materialVO, MultipartFile materialFile) {
        InputStream in = null;
        try {
            User user = userMapper.selectByPrimaryKey(materialVO.getCreateBy());
            in = materialFile.getInputStream();
            //源文件的MD5值
            String materialMd5 = Md5Util.getFtpFileMD5(in, materialFile.getSize());

            //查找是否存在
            Material material = getByCorpIdAndMd5(user.getCorpId(), materialMd5);
            if (material != null) {
                //已结存在，直接返回成功
                return 1;
            }

            //保存到本地
            String originalName = materialFile.getOriginalFilename();
            String md5Name = materialMd5 + originalName.substring(originalName.lastIndexOf("."));
            String filePath = materialVO.getTempPath() + user.getCorpId() + materialVO.getMaterialType() + md5Name;
            FileUtil.saveToLocal(materialFile, filePath);

            //上传到FTP
            String ftpPath = "" + File.separatorChar + user.getCorpId() + File.separatorChar + materialVO.getMaterialType();
            MaterialThreadPool.excuteTask(new MaterialThread(ftpProps, ftpPath, md5Name, new File(filePath)));

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    @Override
    public List<Material> getByCorpId(Long corpId) {
        MaterialExample materialExample = new MaterialExample();
        materialExample.or().andCorpIdEqualTo(corpId);
        List<Material> materialList = materialMapper.selectByExample(materialExample);
        if (materialList != null && materialList.size() > 0) {
            return materialList;
        }
        return new ArrayList<>();
    }

    @Override
    public Material getByCorpIdAndMd5(Long corpId, String md5) {
        MaterialExample materialExample = new MaterialExample();
        materialExample.or().andCorpIdEqualTo(corpId).andMd5EqualTo(md5);
        List<Material> materialList = materialMapper.selectByExample(materialExample);
        if (materialList != null && materialList.size() > 0) {
            return materialList.get(0);
        }
        return null;
    }

}
