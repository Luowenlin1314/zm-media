package com.zm.media.ibs.program.pool.thread;

import com.zm.media.ibs.resources.util.FtpFileUtil;
import com.zm.media.spring.data.FtpProps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by USERA on 2019/2/18.
 */
public class MaterialThread implements Runnable {

    private FtpProps ftpProps;
    private String ftpPath;
    private String filename;
    private File file;

    public MaterialThread(FtpProps ftpProps, String ftpPath, String filename, File file){
        this.ftpProps = ftpProps;
        this.ftpPath = ftpPath;
        this.filename = filename;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            InputStream input = new FileInputStream(file);
            byte[] content = new byte[input.available()];
            input.read(content);
            FtpFileUtil.upload2Ftp(ftpProps,ftpPath,filename,content,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
