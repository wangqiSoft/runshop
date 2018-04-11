package com.runshoptechnology.runshop.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.ColorInt;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;


import com.orhanobut.logger.Logger;

import java.io.EOFException;
import java.io.File;

import okio.Buffer;

/**
 * by y on 2016/4/29.
 */
@SuppressWarnings("ALL")
public class ActivityUtils {

    // 收起软键盘
    public static void closeSyskeyBroad(Activity activity) {
        try {

            if (activity != null && activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
                ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            } else {
                InputMethodManager m = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
//                    m.toggleSoftInput(0, InputMethodManager.HIDE_IMPLICIT_ONLY);
                m.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0); //强制隐藏键盘
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //屏幕高度
    public static int getTop(Activity activity) {
        WindowManager windowManager = activity.getWindowManager();
        int height = windowManager.getDefaultDisplay().getHeight();
        return height;
    }

    //屏幕宽度
    public static int getWidth(Activity activity) {
        WindowManager windowManager = activity.getWindowManager();
        int height = windowManager.getDefaultDisplay().getWidth();
        return height;
    }

    public static DisplayMetrics displayMetrics(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    /**
     * dp转换为px
     */
    public static int toPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        int pxValue = (int) (dpValue * scale + 0.5f);
        Logger.i(dpValue + " dp == " + pxValue + " px");
        
        return pxValue;
    }

    public static float dp2px(Resources resources, float dp) {
        final float scale = resources.getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

    public static float sp2px(Resources resources, float sp) {
        final float scale = resources.getDisplayMetrics().scaledDensity;
        return sp * scale;
    }

    /**
     * px转换为sp
     */
    public static int toSp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        int spValue = (int) (pxValue / fontScale + 0.5f);
        Logger.i(pxValue + " px == " + spValue + " sp");
        return spValue;
    }


    /**
     * 对TextView、Button等设置不同状态时其文字颜色。
     * 参见：http://blog.csdn.net/sodino/article/details/6797821
     * Modified by liyujiang at 2015.08.13
     */
    public static ColorStateList toColorStateList(@ColorInt int normalColor, @ColorInt int pressedColor,
                                                  @ColorInt int focusedColor, @ColorInt int unableColor) {
        int[] colors = new int[]{pressedColor, focusedColor, normalColor, focusedColor, unableColor, normalColor};
        int[][] states = new int[6][];
        states[0] = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        states[1] = new int[]{android.R.attr.state_enabled, android.R.attr.state_focused};
        states[2] = new int[]{android.R.attr.state_enabled};
        states[3] = new int[]{android.R.attr.state_focused};
        states[4] = new int[]{android.R.attr.state_window_focused};
        states[5] = new int[]{};
        return new ColorStateList(states, colors);
    }

    public static ColorStateList toColorStateList(@ColorInt int normalColor, @ColorInt int pressedColor) {
        return toColorStateList(normalColor, pressedColor, pressedColor, normalColor);
    }

    //toolbar高度
    public static int getToolBarTop(Toolbar toolbar) {
        return toolbar.getTop();
    }


    /**
     * 获取应用程序名称
     */
    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * [获取应用程序版本名称信息]
     *
     * @param context
     * @return 当前应用的版本名称
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    //状态栏高度
    public static int getRectTop(Activity activity) {
        Rect outRect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
        int i = outRect.top;
        return i;
    }

    //获取图库路径
    public static File ImagePath() {
        String sdcard = Environment.getExternalStorageDirectory().toString();
        File file = new File(sdcard + "/DCIM");
        if (!file.exists()) {
            file.mkdirs();
        }
        File mFile = new File(file + "/Demo");
        if (!mFile.exists()) {
            mFile.mkdirs();
        }
        return mFile.getAbsoluteFile();
    }

    //获取音频路径
    public static File getVoicePath() {
        String sdcard = Environment.getExternalStorageDirectory().toString();
        File file = new File(sdcard + "/DCIM");
        if (!file.exists()) {
            file.mkdirs();
        }
        File mFile = new File(file + "/voice");
        if (!mFile.exists()) {
            mFile.mkdirs();
        }
        return mFile.getAbsoluteFile();
    }

    //获取视频路径
    public static File getVideoPath() {
        String sdcard = Environment.getExternalStorageDirectory().toString();
        File file = new File(sdcard + "/DCIM");
        if (!file.exists()) {
            file.mkdirs();
        }
        File mFile = new File(file + "/video");
        if (!mFile.exists()) {
            mFile.mkdirs();
        }
        return mFile.getAbsoluteFile();
    }

    //获取图片路径
    public static File getImagePath() {
        String sdcard = Environment.getExternalStorageDirectory().toString();
        File file = new File(sdcard + "/DCIM");
        if (!file.exists()) {
            file.mkdirs();
        }
        File mFile = new File(file + "/smallimgs");
        if (!mFile.exists()) {
            mFile.mkdirs();
        }
        return mFile.getAbsoluteFile();
    }

    public static boolean isPlaintext(Buffer buffer) {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false; // Truncated UTF-8 sequence.
        }
    }

    public static String unicodeToUTF_8(String src) {
        if (null == src) {
            return null;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < src.length(); ) {
            char c = src.charAt(i);
            if (i + 6 < src.length() && c == '\\' && src.charAt(i + 1) == 'u') {
                String hex = src.substring(i + 2, i + 6);
                try {
                    out.append((char) Integer.parseInt(hex, 16));
                } catch (NumberFormatException nfe) {
                    nfe.fillInStackTrace();
                }
                i = i + 6;
            } else {
                out.append(src.charAt(i));
                ++i;
            }
        }
        return out.toString();

    }

    public static String getDeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String IMEI = tm.getDeviceId();
        return IMEI;
    }
}
