package com.tydfd.httputils_liudong;

/**
 * @Classname RequestData
 * @Description TODO
 * @Date 2019/7/31 10:08
 * @Created by liudo
 * @Author by liudo
 */
public class RequestData {
    private String PostStr;

    public String getPostStr() {
        return PostStr;
    }

    public void setPostStr(String postStr) {
        PostStr = postStr;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "PostStr='" + PostStr + '\'' +
                '}';
    }
}
