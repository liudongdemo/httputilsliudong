package com.tydfd.ldlibrary.utils;

import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 创建人：CYC
 * 创建时间：2019/1/29.
 * 类描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class MD5Utils {


    public static String encode(String str) {
        StringBuffer buffer = new StringBuffer();

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(str.getBytes());
            for (byte b : digest) {
                int x = b & 0xff;  // 将byte转换2位的16进制int类型数
                String s = Integer.toHexString(x); // 将一个int类型的数转为2位的十六进制数
                if (s.length() == 1) {
                    s = "0" + s;
                }
                buffer.append(s);
                Log.d("vivi", "encode: " + s);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}

