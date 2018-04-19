package com.runshoptechnology.runshop;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.blankj.utilcode.util.Utils;
import com.mob.MobSDK;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.runshoptechnology.runshop.config.ApiContans;
import com.runshoptechnology.runshop.utils.crash.Cockroach;

import es.dmoral.toasty.Toasty;

/**
 * @author Ryder
 * create at 2018/4/6 11:04
 * package name:com.runshoptechnology.runshop
 * description: 自定义的 application
 **/
public class Myapplication extends Application {


    //整个app的上下文
    public static Context AppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext = getApplicationContext();
        //初始化toast
        initToast();
        //mob 初始化
        MobSDK.init(this);
        //设置日志打印的格式
        Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().tag(ApiContans.LogTAG).build()) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return ApiContans.DEBUG;
            }

        });
        //初始化工具类
        Utils.init(this);
        //初始化崩溃收集
//        if (!ApiContans.DEBUG) {
//            initCrash();
//        }

    }
    /**
     * 初始化 toast
     */
    private void initToast() {
        Toasty.Config.getInstance()
                .setErrorColor(getResources().getColor(R.color.red)) // optional
                .setInfoColor(getResources().getColor(R.color.skyblue)) // optional
                .setSuccessColor(getResources().getColor(R.color.springgreen)) // optional
                .setWarningColor(getResources().getColor(R.color.darkorange)) // optional
                .setTextColor(getResources().getColor(R.color.white)) // optional
                .tintIcon(false) // optional (apply textColor also to the icon)
                .setToastTypeface(Typeface.DEFAULT) // optional
                .setTextSize(15) // optional
                .apply(); // required
    }

    /**
     * 初始化崩溃的捕获事件
     */
    private void initCrash() {
        Cockroach.install(new Cockroach.ExceptionHandler() {
            @Override
            public void handlerException(final Thread thread, final Throwable throwable) {

                Log.e("Cockroach", "MainThread: " + Looper.getMainLooper().getThread() + "  curThread: " + Thread.currentThread());
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.e("AndroidRuntime", "--->CockroachException:" + thread + "<---", throwable);
                        } catch (Throwable e) {
                            Log.e("AndroidRuntime", "e:" + e.toString());
                        }
                    }
                });
            }
        });
    }

}
