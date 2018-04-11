package com.runshoptechnology.runshop.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by zns on 2017/4/14.
 */

public class MyBasePrestenerImpl<T extends BaseView> {
    protected CompositeDisposable mSubscriptions;
    protected T mView;
    protected BaseActivity mact;

    public MyBasePrestenerImpl(T mView) {
        this.mView = mView;
        mSubscriptions = new CompositeDisposable();
    }

    public MyBasePrestenerImpl(T mView, BaseActivity baseActivity) {
        this.mView = mView;
        this.mact = baseActivity;
        mSubscriptions = new CompositeDisposable();
    }

//    public boolean isLogined(ResponseData responseData) {
//        if (responseData == null)
//            return false;
//        if ("30002".equals(responseData.getCode())) {
//            return true;
//        }
//        if (("30006".equals(responseData.getCode()))) {
//            ExceptionUtils.fail(mact, responseData);
//            return true;
//        }
//        return false;
//    }
}
