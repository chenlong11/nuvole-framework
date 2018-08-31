package com.nuvole.framework.utils;

import cn.hutool.crypto.digest.DigestUtil;

/**
 * Created by chenlong
 * Date：2018/7/4
 * time：10:50
 */
public class EncryptionUtil {

    public static String pwdEncryption(String source) {
        return DigestUtil.md5Hex(DigestUtil.sha256Hex(source));
    }

}
