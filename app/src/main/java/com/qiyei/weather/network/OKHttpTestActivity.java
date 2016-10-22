package com.qiyei.weather.network;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qiyei.weather.R;
import com.qiyei.weather.activity.BaseActivity;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpTestActivity extends BaseActivity {

    @Bind(R.id.tv1)
    TextView mTv1;
    @Bind(R.id.activity_okhttp_test)
    RelativeLayout mActivityOkhttpTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_test);
        ButterKnife.bind(this);

        okHttpGet();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    private void okHttpGet() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://www.baidu.com").build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String result = response.body().toString();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTv1.setText(result);
                    }
                });
            }
        });

    }

    private void okHttpPost() {

    }



}
