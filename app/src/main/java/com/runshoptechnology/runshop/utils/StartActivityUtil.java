package com.runshoptechnology.runshop.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.runshoptechnology.runshop.ui.GuideActivity;
import com.runshoptechnology.runshop.ui.MainActivity;
import com.runshoptechnology.runshop.ui.me.LoginActivity;

/**
 * @author Ryder
 * create at 2018/4/6 14:25
 * package name:com.runshoptechnology.runshop.utils
 * description: 同意管理界面的跳转
 **/
public class StartActivityUtil {
    /**
     * 跳转主页面
     *
     * @param context
     * @param bundle
     */
    public static void GoMainActivity(Context context, Bundle bundle) {
        Intent intent = new Intent(context,MainActivity.class);
        intent.putExtras(bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    /**
     * 跳转引导页页面
     *
     * @param context
     * @param bundle
     */
    public static void GoGuideActivity(Context context, Bundle bundle) {
        Intent intent = new Intent(context,GuideActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 跳转登录页面
     *
     * @param context
     * @param bundle
     */
    public static void GoLoginActivity(Context context, Bundle bundle) {
        Intent intent = new Intent(context,LoginActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
    /**
     * 跳转下一个页面
     *
     * @param context             上下文
     * @param clazz               下一个界面
     * @param isFinishCurrentPage 是否结束当前界面
     */
    public static void navigatorToNextPage(Context context, Class clazz, boolean isFinishCurrentPage) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
        if (isFinishCurrentPage) ((Activity) context).finish();
    }

}
