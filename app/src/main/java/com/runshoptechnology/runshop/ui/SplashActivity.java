package com.runshoptechnology.runshop.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.flyco.systembar.SystemBarHelper;
import com.runshoptechnology.runshop.R;
import com.runshoptechnology.runshop.base.BaseActivity;
import com.runshoptechnology.runshop.base.BasePresenter;
import com.runshoptechnology.runshop.utils.StartActivityUtil;
import com.runshoptechnology.runshop.widget.CountDownView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

/**
 * @author Ryder
 * create at 2018/4/6 10:41
 * description:  启动页
 **/
public class SplashActivity extends AppCompatActivity implements CountDownView.CountDownTimerListener {

    @BindView(R.id.iv_splash)
    ImageView splashIG;
    @BindView(R.id.cdv)
    CountDownView countDownView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
//        Toasty.error(this, "测试错误信息").show();
//        Toasty.info(this, "测试正常信息").show();
//        Toasty.success(this, "测试成功信息").show();
//        Toasty.warning(this, "测试警告信息").show();
        countDownView.setCountDownTimerListener(this);
        countDownView.start();
    }

    @OnClick(R.id.cdv)
    public void onClick() {
        //是否显示了引导页
//        if (PreferencesUtils.getBoolean(this, PreferencesConfig.GuiActivityShow)) {
        countDownView.onCancle();
        StartActivityUtil.GoMainActivity(this, new Bundle());
//        } else {
//            StartActivityUtil.GoGuideActivity(this,new Bundle());
//        }

    }


    //开始计时
    @Override
    public void onStartCount() {

    }

    //计时结束
    @Override
    public void onFinishCount() {
        //是否显示了引导页
//        if (PreferencesUtils.getBoolean(this, PreferencesConfig.GuiActivityShow)) {
            StartActivityUtil.GoMainActivity(this, new Bundle());
//        } else {
//            StartActivityUtil.GoGuideActivity(this,new Bundle());
//        }

    }
}
