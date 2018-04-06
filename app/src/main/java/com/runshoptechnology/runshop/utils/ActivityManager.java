package com.runshoptechnology.runshop.utils;

import android.app.Activity;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/**
* @author Ryder
* create at 2018/4/6 14:17
 * package name:com.runshoptechnology.runshop.utils
* description: 统一管理activity
**/
public class ActivityManager {
    private static ActivityManager instance;
    private List<SoftReference<Activity>> activityStack = new ArrayList<SoftReference<Activity>>();

    public static synchronized ActivityManager getInstance() {
        if (instance == null) {
            instance = new ActivityManager();
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        if (activityStack != null) {
            activityStack.add(new SoftReference<Activity>(activity));
        }
    }

    public void finishActivity(Activity activity) {
        if (!isNullOrEmpty(activityStack)) {
            for (SoftReference<Activity> s : activityStack) {
                if (s.get().getClass().getName().equals(activity.getClass().getName())) {
                    s.get().finish();
                }
            }
        }
    }

    public void removeActivity(Activity activity) {
        if (!isNullOrEmpty(activityStack)) {
            for (SoftReference<Activity> s : activityStack) {
                if (s.get().getClass().getName().equals(activity.getClass().getName())) {
                    activityStack.remove(s);
                }
            }
        }
    }

    public void finishAllActivity() {
        if (!isNullOrEmpty(activityStack)) {
            for (SoftReference<Activity> s : activityStack) {
                Activity activity = s.get();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }
    /**
     * 对象非空判断
     *
     * @param obj
     * @return
     */
    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null)
            return true;

        if (obj instanceof CharSequence)
            return ((CharSequence) obj).length() == 0;

        if (obj instanceof Collection)
            return ((Collection) obj).isEmpty();

        if (obj instanceof Map)
            return ((Map) obj).isEmpty();

        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            boolean empty = true;
            for (int i = 0; i < object.length; i++)
                if (!isNullOrEmpty(object[i])) {
                    empty = false;
                    break;
                }
            return empty;
        }
        return false;
    }

//    public void finishAllActivityNoLogin() {
//        if (!Utils.isNullOrEmpty(activityStack)) {
//            for (SoftReference<Activity> s : activityStack) {
//                Activity activity = s.get();
//                if (activity != null && !(activity instanceof LoginActivity)) {
//                    activity.finish();
//                }
//            }
//        }
//    }
}
