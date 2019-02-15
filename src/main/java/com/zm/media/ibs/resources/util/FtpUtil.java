package com.zm.media.ibs.resources.util;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FtpUtil {

    /**
     * 中文编码
     */
    public static String charsetName = "GBK";

    /**
     * FTP连接.
     */
    public FTPClient ftpClient;

    public FtpUtil() {
        this.ftpClient = new FTPClient();
        this.ftpClient.setUseEPSVwithIPv4(true);
        this.ftpClient.enterLocalPassiveMode();
        this.ftpClient.setRemoteVerificationEnabled(false);
        this.ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
    }

    /**
     * 打开FTP服务.
     * @throws IOException
     */
    public void connect(String hostName, int port, String userName, String password) throws IOException {
        int reply; // 服务器响应值
        // 连接至服务器
        ftpClient.connect(hostName,port);
        // 获取响应值
        reply = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply) && reply < 500) {
            // 断开连接
            ftpClient.disconnect();
            throw new IOException("connect fail: " + reply);
        }
        // 登录到服务器
        ftpClient.login(userName, password);
        //发送OPTS UTF8指令尝试支持utf-8
        if (FTPReply.isPositiveCompletion(ftpClient.sendCommand("OPTS UTF8", "ON")))
        {
            charsetName = "UTF-8";
        }
        ftpClient.setControlEncoding(charsetName);
        // 获取响应值
        reply = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply) && reply < 500 ) {
            // 断开连接
            ftpClient.disconnect();
            throw new IOException("connect fail: " + reply);
        } else {
            // 获取登录信息
            FTPClientConfig config = new FTPClientConfig(ftpClient.getSystemType().split(" ")[0]);
            config.setServerLanguageCode("zh");
            ftpClient.configure(config);
            // 使用被动模式设为默认
            ftpClient.enterLocalPassiveMode();
            // 二进制文件支持
            ftpClient.setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);
        }
    }

    /**
     * 关闭FTP服务.
     * @throws IOException
     */
    public void disconnect() throws IOException {
        if (ftpClient != null) {
            // 登出FTP
            ftpClient.logout();
            // 断开连接
            ftpClient.disconnect();
        }
    }

    public boolean changeDirectory(String ftpPath) throws IOException {
        //参数是null，直接返回false
        if (StringUtils.isEmpty(ftpPath)) {
            return false;
        }

        if(ftpClient.changeWorkingDirectory(ftpPath)) {
            //目录已存在，无需创建
            return true;
        }else {
            //目录不存在，创建目录
            if(makeDirectory(ftpPath)) {
                if(ftpClient.changeWorkingDirectory(ftpPath)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 递归创建远程服务器目录
     *
     * @param ftpPath		远程服务器文件绝对路径
     * @return status 		目录创建是否成功
     * @throws IOException	抛出IO异常
     */
    public boolean makeDirectory(String ftpPath) throws IOException {
        String[] dirs = ftpPath.split("/");
        //按顺序检查目录是否存在，不存在则创建目录
        for(int i = 0; dirs!=null && i < dirs.length; i++) {
            if(!ftpClient.changeWorkingDirectory(dirs[i])) {
                if(ftpClient.makeDirectory(dirs[i])) {
                    if(!ftpClient.changeWorkingDirectory(dirs[i])) {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean upload(String fileName, byte[] content, boolean isOverwrite) throws IOException {
        FTPFile[] files = ftpClient.listFiles(fileName);
        if (files.length == 1) {
            if (isOverwrite) {
                delete(fileName);
                return upload(fileName, content, 0);
            } else {
                long offset = files[0].getSize();
                return upload(fileName, content, offset);
            }
        } else {
            return upload(fileName, content, 0);
        }
    }

    /**
     * 上传文件到服务器,新上传和断点续传
     *
     * @param fileName	远程文件名，在上传之前已经将服务器工作目录做了改变
     * @param content		本地文件File句柄，绝对路径
     * @param offset	需要显示的处理进度步进值
     * @throws IOException	抛出IO异常
     */
    public boolean upload(String fileName, byte[] content, long offset) throws IOException {
        OutputStream out = ftpClient.appendFileStream(fileName);
        // 断点续传
        if (offset > 0) {
            ftpClient.setRestartOffset(offset);
        }
        out.write(content);

        out.flush();
        out.close();

        return ftpClient.completePendingCommand();
    }

    public boolean upload(Map<String, byte[]> map, boolean isOverwrite) throws IOException {
        Map<String, Long> offsets = new HashMap<>();
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            FTPFile[] files = ftpClient.listFiles(entry.getKey());
            if (files.length == 1) {
                if (isOverwrite) {
                    delete(entry.getKey());
                    offsets.put(entry.getKey(), 0L);
                } else {
                    long offset = files[0].getSize();
                    offsets.put(entry.getKey(), offset);
                }
            } else {
                offsets.put(entry.getKey(), 0L);
            }
        }
        return upload(map, offsets);
    }

    public boolean upload(Map<String, byte[]> map, Map<String, Long> offsets) throws IOException {
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            OutputStream out = ftpClient.appendFileStream(entry.getKey());
            long offset = offsets.get(entry.getKey());
            // 断点续传
            if (offset > 0) {
                ftpClient.setRestartOffset(offset);
            }

            out.write(entry.getValue());

            out.flush();

            out.close();
            ftpClient.completePendingCommand();
        }
        return true;
    }

    public byte[] download(String ftpPath, String filename, int offset, int size) throws IOException {
        if (!StringUtils.isEmpty(ftpPath)) {
            changeDirectory(ftpPath);
            FTPFile[] files = ftpClient.listFiles(filename);
            if (files != null && files.length > 0) {
                FTPFile file = files[0];
                byte[] data = new byte[size];
                InputStream in = ftpClient.retrieveFileStream(file.getName());
                byte[] content = IOUtils.toByteArray(in);
                System.arraycopy(content, offset, data, 0, size);

                in.close();
                return data;
            }
            return null;
        } else {
            return null;
        }
    }

    public void delete(String ftpPath) throws IOException {
        if (!StringUtils.isEmpty(ftpPath)) {
            ftpClient.deleteFile(ftpPath);
        }
    }

    public void delete(List<String> ftpPaths) throws IOException {
        for (String ftpPath : ftpPaths) {
            if (!StringUtils.isEmpty(ftpPath)) {
                ftpClient.deleteFile(ftpPath);
            }
        }
    }

    public FTPFile[] listFiles(String ftpPath) throws IOException {
        if (!StringUtils.isEmpty(ftpPath)) {
            return ftpClient.listFiles(ftpPath);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        FtpUtil ftpUtil = new FtpUtil();
        try {
            ftpUtil.connect("172.16.1.180", 21, "test", "test");
            byte[] content = ftpUtil.download("test/", "ftp.txt", 10, 20);
            System.out.println(new String(content));
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


}
