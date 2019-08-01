package com.tydfd.ldlibrary.utils;

import java.io.InputStream;

public interface CallbackListener {

    void onSuccess(InputStream inputStream);

    void onFailure();

}
