package com.runshoptechnology.runshop.ui.me;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.runshoptechnology.runshop.R;
import com.runshoptechnology.runshop.base.BaseActivity;
import com.runshoptechnology.runshop.base.BasePresenter;
import com.runshoptechnology.runshop.base.MyBasePrestenerImpl;
import com.runshoptechnology.runshop.bean.RequestBean;
import com.runshoptechnology.runshop.bean.ResponseData;
import com.runshoptechnology.runshop.bean.UserBean;
import com.runshoptechnology.runshop.contract.LoginContract;
import com.runshoptechnology.runshop.presenter.LoginPresenterImpl;
import com.runshoptechnology.runshop.widget.TopBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
* @author Ryder
* create at 2018/4/11 9:50
 * package name:com.runshoptechnology.runshop.ui.me
* description: 登录界面
**/
public class LoginActivity extends BaseActivity<LoginContract.loginPresenter>  implements LoginContract.loginView {

    @BindView(R.id.login_Topbar)
    TopBar loginTopbar;

    @BindView(R.id.login_btn)
    Button btnLogin;

    @Override
    protected int getlayoutContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginContract.loginPresenter generatePresenter() {
        return new LoginPresenterImpl(this,this);
    }

    @Override
    protected View setTopView() {
        return loginTopbar;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    public void loginSucess(ResponseData<UserBean> data) {

    }



    @Override
    public void fail(String msg) {

    }

    @Override
    public void noData() {

    }

    @Override
    public void showProgress() {
        showProgressDialog("");
    }

    @Override
    public void hideProgress() {
        closeProgressDialog();
    }

    @OnClick(R.id.login_btn)
    public void onClick(){
//        mPresenter.login(new RequestBean(),false );
    }
}
