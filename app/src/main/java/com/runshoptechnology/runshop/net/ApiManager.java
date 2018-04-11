package com.runshoptechnology.runshop.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.runshoptechnology.runshop.config.ApiContans;
import com.runshoptechnology.runshop.utils.log.HttpLogger;

import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.runshoptechnology.runshop.config.ApiContans.timeOut;
import static com.runshoptechnology.runshop.config.BaseUrl.HOST;


/**
 *
 * 网络管理类
 */

public class ApiManager {
    public static Retrofit retrofit;
    private static OkHttpClient okHttpClient;

    /**
     * 初始化okHttp
     * @return
     */
    public static OkHttpClient GetOkHttpClient() {
        if (okHttpClient == null) {
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLogger());
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder().addInterceptor(logInterceptor)
                    .connectTimeout(timeOut, TimeUnit.SECONDS)
                    .readTimeout(timeOut, TimeUnit.SECONDS)
                    .writeTimeout(timeOut, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(false)
                    .build();
            return okHttpClient;
        } else {
            return okHttpClient;
        }
    }

    //接口服务
    public static ApiService getApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 使用RxJava作为回调适配器
                    //配置OkHttp
                    .client(GetOkHttpClient())
                    .build();
        }
        return retrofit.create(ApiService.class);
    }
}
