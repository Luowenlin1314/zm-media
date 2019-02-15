package com.zm.media.ibs.protocol.base;


import com.zm.media.common.util.JacksonUtils;
import com.zm.media.ibs.protocol.entity.Identity;
import com.zm.media.ibs.protocol.terminal.IdentityPro;

/**
 * Created by USERA on 2019/2/14.
 */
public class BasePro {

    //协议名称
    protected Integer name;
    //协议数据
    protected Object data;

    public Integer getName() {
        return name;
    }

    public Object getData() {
        return data;
    }

    /**
     * 获取当前对象json数据
     * @return
     */
    public String toJson(){
        return JacksonUtils.pojo2Json(this);
    }

    public static void main(String[] args) {
        Identity identity = new Identity();
        identity.setCorpCode("aaaa");
        identity.setDeviceCode("test1");
        identity.setNetIP("172.16.1.103");
        identity.setNetMac("8a:37:d9:a9:33:37");
        identity.setNetType(1);
        identity.setResolution("1920*1080");
        identity.setVersion("android4.2");
        IdentityPro identityPro = new IdentityPro(identity);
        String json = JacksonUtils.pojo2Json(identityPro);
        System.out.println(json);

        Identity identity1 = (Identity) identityPro.getData();
        System.out.println(identity1.getCorpCode());

        String json1 = JacksonUtils.pojo2Json(identity1);
        System.out.println(json1);

        Identity identity2 = JacksonUtils.json2Pojo(json1, Identity.class);
        System.out.println(identity2.getCorpCode());

    }

}
