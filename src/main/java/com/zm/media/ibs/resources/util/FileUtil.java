package com.zm.media.ibs.resources.util;


import com.zm.media.spring.data.FtpProps;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileUtil {

    /***
     * 列出指定路径下的所有文件
     * @param ftpPath
     * @return
     */
    public static FTPFile[] listFiles(FtpProps ftpProps, String ftpPath){
        FtpUtil ftpUtil = new FtpUtil();
        try {
            ftpUtil.connect(ftpProps.getHost(), ftpProps.getPort(), ftpProps.getUsername(), ftpProps.getPassword());
            FTPFile[] files = ftpUtil.listFiles(ftpPath);
            return files;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ftpUtil.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] download(FtpProps ftpProps, String ftpPath, String filename, long offset, long length) {
        FtpUtil ftpUtil = new FtpUtil();
        try {
            ftpUtil.connect(ftpProps.getHost(), ftpProps.getPort(), ftpProps.getUsername(), ftpProps.getPassword());
            return ftpUtil.download(ftpPath, filename, (int)offset, (int)length);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ftpUtil.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 上传文件
     * @param ftpProps
     * @param ftpPath
     * @param filename
     * @param content
     * @return
     */
    public static boolean upload2Ftp(FtpProps ftpProps, String ftpPath, String filename, byte[] content, boolean isOverwrite){
        FtpUtil ftpUtil = new FtpUtil();
        try {
            ftpUtil.connect(ftpProps.getHost(), ftpProps.getPort(), ftpProps.getUsername(), ftpProps.getPassword());
            ftpUtil.changeDirectory(ftpPath);
            return ftpUtil.upload(filename, content, isOverwrite);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ftpUtil.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 上传视频文件
     * @param ftpProps
     * @param ftpPath
     * @param filename
     * @param content
     * @param largeThumbnailName
     * @param largeThumbnail
     * @param smallThumbnailName
     * @param smallThumbnail
     * @return
     */
    public static boolean upload2Ftp(FtpProps ftpProps, String ftpPath, String filename, byte[] content, boolean isOverwrite, String largeThumbnailName, byte[] largeThumbnail, String smallThumbnailName, byte[] smallThumbnail){
        FtpUtil ftpUtil = new FtpUtil();
        try {
            Map map = buildFtpUploadingData(filename, content, largeThumbnailName, largeThumbnail, smallThumbnailName, smallThumbnail);
            ftpUtil.connect(ftpProps.getHost(), ftpProps.getPort(), ftpProps.getUsername(), ftpProps.getPassword());
            ftpUtil.changeDirectory(ftpPath);
            return ftpUtil.upload(map, isOverwrite);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ftpUtil.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 删除文件
     * @param ftpProps
     * @param ftpPaths
     */
    public static void deleteFromFtp(FtpProps ftpProps, List<String> ftpPaths) {
        FtpUtil ftpUtil = new FtpUtil();
        try {
            ftpUtil.connect(ftpProps.getHost(), ftpProps.getPort(), ftpProps.getUsername(), ftpProps.getPassword());
            ftpUtil.delete(ftpPaths);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ftpUtil.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static Map buildFtpUploadingData(String filename, byte[] content, String lThumbnailName, byte[] lThumbnail, String sThumbnailName, byte[] sThumbnail) {
        Map<String, byte[]> map = new HashMap<>();
        if (!StringUtils.isEmpty(filename) && content.length > 0) {
            map.put(filename, content);
        }
        if (!StringUtils.isEmpty(lThumbnailName) && lThumbnail.length > 0) {
            map.put(lThumbnailName, lThumbnail);
        }
        if (!StringUtils.isEmpty(sThumbnailName) && sThumbnail.length > 0) {
            map.put(sThumbnailName, sThumbnail);
        }
        return map;
    }
}
