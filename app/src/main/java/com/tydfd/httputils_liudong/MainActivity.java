package com.tydfd.httputils_liudong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tydfd.ldlibrary.http.NeOkHttp;
import com.tydfd.ldlibrary.http.ResponseBean;
import com.tydfd.ldlibrary.http.TimeDateUtils;
import com.tydfd.ldlibrary.http.UserBean;
import com.tydfd.ldlibrary.utils.IJsonDataListener;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;
    /**
     * http://www.mxnzp.com/api/holiday/single/20181208 获取今日运势http://www.mxnzp.com/api/holiday/single/
     */
    private String url = "http://www.mxnzp.com/api/holiday/single/";
    //    private String url2 = "http://192.168.120.194:8080/Demo/ResponseData";
    private String getUrl = "http://www.chengshibao.com:8380/gas/sendstatus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        mTextView = findViewById(R.id.textView);
        String time = TimeDateUtils.getCurrentDateStr(TimeDateUtils.FORMAT_TYPE_1);
        url = url+ time;
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
                UserBean userBean = new UserBean();
                userBean.setUsername("");
                userBean.setPassword("123456");
                RequestData requestData = new RequestData();
                requestData.setPostStr("IURkiXhA11NwgYz7/7g3XIuCQ5dLw9UxEU9V9XELfP/0srBVyIVcITBz9S8MBgAamK+AH3rVkpVc\n" +
                        "    MJ/eq29oUe2BzV+GMIaT4vCS99JWgiS6DVoOcSLHEUdW3CHFNVCDrJ9WC4VgVb2ZVoPuuuhbhZ6l\n" +
                        "    PApPZ3H3wyqKz80dXvKZVoPuuuhbhZ6lPApPZ3H3wyqKz80dXvJyHDT2DEOWfmBTKTa3+9mX5qj7\n" +
                        "    R9fw8lp/PT9PF9w24lgGCfbmtIsvvVOydOjGYuAODw7lt0R/vjGt8dpGTN0X72vay5Whvu9KDOf5\n" +
                        "    18LylYhEOEYEJN/SecJLZI3GNcc=");
                NeOkHttp.sendJsonRequest(null, url,userBean, ResponseBean.class, new IJsonDataListener<ResponseBean>() {
                    @Override
                    public void onSuccess(final ResponseBean rb) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTextView.setText(rb.getData());
                            }
                        });
                        Log.i("===> ",rb.toString());
                    }

                    @Override
                    public void onFailure() {

                    }
                });
            }
        });


    }
}
