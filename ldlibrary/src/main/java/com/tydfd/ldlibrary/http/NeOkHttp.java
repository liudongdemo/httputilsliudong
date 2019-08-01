package com.tydfd.ldlibrary.http;


import com.tydfd.ldlibrary.utils.CallbackListener;
import com.tydfd.ldlibrary.utils.HttpTask;
import com.tydfd.ldlibrary.utils.IHttpRequest;
import com.tydfd.ldlibrary.utils.IJsonDataListener;
import com.tydfd.ldlibrary.utils.JsonCallbackListener;
import com.tydfd.ldlibrary.utils.JsonHttpRequest;
import com.tydfd.ldlibrary.utils.ThreadPoolManager;

/**
 * @author liudo
 */
public class NeOkHttp {
    /**
     *
     * @param requestData 请求数据
     * @param url 请求url
     * @param userBean Basic认证
     * @param response
     * @param listener
     * @param <T>
     * @param <M>
     */
    public static<T,M> void sendJsonRequest(T requestData, String url,UserBean userBean,
                                            Class<M> response, IJsonDataListener listener){
        IHttpRequest httpRequest = new JsonHttpRequest();
        CallbackListener callbackListener = new JsonCallbackListener<>(response,listener);
        HttpTask httpTask = new HttpTask(requestData,url,userBean,httpRequest,callbackListener);
        ThreadPoolManager.getInstance().addTask(httpTask);
    }


}
