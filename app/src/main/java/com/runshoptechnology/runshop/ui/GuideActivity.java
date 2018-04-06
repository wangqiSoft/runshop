package com.runshoptechnology.runshop.ui;

import android.content.Context;
import android.view.View;

import com.runshoptechnology.runshop.R;
import com.runshoptechnology.runshop.base.BaseActivity;
import com.runshoptechnology.runshop.config.PreferencesConfig;
import com.runshoptechnology.runshop.utils.PreferencesUtils;

/**
 * @author Ryder
 * create at 2018/4/6 14:35
 * package name:com.runshoptechnology.runshop.ui
 * description: 这个是引导页界面
 **/
public class GuideActivity extends BaseActivity {


    @Override
    protected int getlayoutContentView() {
        return R.layout.activity_guide;
    }

    @Override
    protected View setTopView() {
        return super.setTopView();
    }

    @Override
    protected void initView() {
        super.initView();
        PreferencesUtils.putBoolean(this, PreferencesConfig.GuiActivityShow,true);
    }
}
