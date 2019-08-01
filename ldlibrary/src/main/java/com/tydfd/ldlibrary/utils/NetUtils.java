package com.tydfd.ldlibrary.utils;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Classname NetUtils
 * @Description TODO
 * @Date 2019/7/18 17:19
 * @Created by liudo
 * @Author by liudo
 */
public class NetUtils {

    public String getAuthResponse(String urlString,String responseHead) throws MalformedURLException {
        String realm, nonce, uri, qop, response, opaque;
        int nc = 1;
        int cnonce = 1;
        URL url = new URL(urlString);

        String tmpSubString;
        String KEY_REALM = "realm";
        String KEY_QOP = "qop";
        String KEY_NONCE = "nonce";
        String KEY_OPAQUE = "opaque";
        int index1, index2;
        //skip = "
        index1 = responseHead.indexOf(KEY_REALM) + KEY_REALM.length() + 2;
        tmpSubString = responseHead.substring(index1);
        index2 = tmpSubString.indexOf("\"");
        realm = tmpSubString.substring(0, index2);
        //skip = "
        index1 = responseHead.indexOf(KEY_QOP) + KEY_QOP.length() + 2;
        tmpSubString = responseHead.substring(index1);
        index2 = tmpSubString.indexOf("\"");
        qop = tmpSubString.substring(0, index2);
        ////skip = "
        index1 = responseHead.indexOf(KEY_NONCE) + KEY_NONCE.length() + 2;
        tmpSubString = responseHead.substring(index1);
        index2 = tmpSubString.indexOf("\"");
        nonce = tmpSubString.substring(0, index2);
        //         nonce="1130278534";//skip = "
        index1 = responseHead.indexOf(KEY_OPAQUE) + KEY_OPAQUE.length() + 2;
        tmpSubString = responseHead.substring(index1);
        index2 = tmpSubString.indexOf("\"");
        opaque = tmpSubString.substring(0, index2);

        index1 = urlString.indexOf("/cgi-bin");
        uri = urlString.substring(index1);


        String HA1, HA2;
        HA1 = MD5Utils.encode("admin" + ":" + realm + ":" + "admin");
        HA2 = MD5Utils.encode("GET:" + uri);
        response = MD5Utils.encode(HA1 + ":" + nonce + ":" + nc + ":" + cnonce + ":" + qop + ":" + HA2);
        String authResponse = "Digest username=\"admin\", realm=\"" + realm + "\","
                + "nonce=\"" + nonce + "\","
                + "uri=\"" + uri + "\","
                + "qop=" + qop + ","
                + "nc=" + nc + ","
                + "cnonce=" + "\"" + cnonce + "\","
                + "response=\"" + response + "\","
                + "opaque=\"\"" + opaque + "\"\"";

        return authResponse;
    }



}
