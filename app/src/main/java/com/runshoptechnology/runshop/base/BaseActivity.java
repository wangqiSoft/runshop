package com.runshoptechnology.runshop.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blankj.utilcode.util.BarUtils;
import com.flyco.systembar.SystemBarHelper;
import com.runshoptechnology.runshop.R;
import com.runshoptechnology.runshop.utils.ActivityManager;

import butterknife.ButterKnife;

/**
 * @author Ryder
 * create at 2018/4/6 10:39
 * description:  activity 的基类
 **/
public abstract class BaseActivity <P extends BasePresenter > extends AppCompatActivity {
    protected P mPresenter;
    private ProgressDialog progressDialog;

    protected abstract P generatePresenter();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getlayoutContentView() > 0) {
            setContentView(getlayoutContentView());
            ButterKnife.bind(this);
        }
        mPresenter = generatePresenter();
        initView();
        SystemBarHelper.tintStatusBar(this, getResources().getColor(R.color.mainTabColor));
//        SystemBarHelper.immersiveStatusBar(this);
//        if (setTopView() != null) {
//            SystemBarHelper.setHeightAndPadding(this, setTopView());
//        }
        ActivityManager.getInstance().addActivity(this);

    }


    protected View setTopView() {
        return null;
    }

    protected int getlayoutContentView() {
        return 0;
    }

    protected void initView() {

    }
    /**
     * 显示提示框
     */
    public void showProgressDialog(String msg) {
        if ((!isFinishing()) && (progressDialog == null)) {
            progressDialog = new ProgressDialog(this);
        }
        if (msg == null || "".equals(msg)) {
            msg = "加载中……";
        }
        this.progressDialog.setMessage(msg);
        //this.progressDialog.setCancelable(false);
        this.progressDialog.setCanceledOnTouchOutside(false);
        this.progressDialog.show();
    }

    /**
     * 关闭提示框
     */
    public void closeProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

}
