package com.zm.media.ibs.protocol.terminal;

import com.zm.media.ibs.protocol.base.BasePro;
import com.zm.media.ibs.protocol.constant.ProtocolCons;

/**
 * Created by USERA on 2019/2/14.
 * 终端身份校验
 */
public class IdentityPro extends BasePro {

    public IdentityPro(Object data){
        this.name = ProtocolCons.TERMINAL_IDENTITY;
        this.data = data;
    }


}
