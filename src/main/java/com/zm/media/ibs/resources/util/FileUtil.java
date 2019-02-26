package com.zm.media.ibs.resources.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by USERA on 2019/2/18.
 */
public class FileUtil {

    /**
     * 保存到本地
     * @param multipartFile
     * @param FileDir
     */
    public static void saveToLocal(MultipartFile multipartFile, String FileDir){
        try {
            File file = new File(FileDir);
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
