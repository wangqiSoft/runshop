package com.runshoptechnology.runshop;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.preference.PreferenceActivity;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;

import com.mob.MobSDK;

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

}
