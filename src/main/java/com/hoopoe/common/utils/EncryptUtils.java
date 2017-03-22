package com.hoopoe.common.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * Created by wildcrab on 17-3-23.
 */
public class EncryptUtils {

    /**
     * 加密密码
     * @param password 密码
     * @return
     */
    public static String encrypt(String password) {
        if (StringUtils.isEmpty(password)) {
            throw new RuntimeException("加密内容不能为空！");
        }
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public static boolean checkMatch(String hashed, String candidate){
        if (StringUtils.isEmpty(hashed) || StringUtils.isEmpty(candidate)) {
            return false;
        }
        return BCrypt.checkpw(candidate ,hashed);
    }

    public static void main(String[] args){
        String hashed = encrypt("kaa123");
        System.out.println(hashed);
        if (checkMatch(hashed ,"kaa123")){
            System.out.println("ok!");
        }else{
            System.out.println("no !!!");
        }
    }
}
