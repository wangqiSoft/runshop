package com.runshoptechnology.runshop.contract;

import com.runshoptechnology.runshop.base.BasePresenter;
import com.runshoptechnology.runshop.base.BaseView;
import com.runshoptechnology.runshop.bean.RequestBean;
import com.runshoptechnology.runshop.bean.ResponseData;
import com.runshoptechnology.runshop.bean.UserBean;

/**
 * @author Ryder
 * create at 2018/4/11 9:29
 * package name:com.runshoptechnology.runshop.contract
 * description:  登录的contract
 **/
public interface LoginContract {

    interface loginPresenter extends BasePresenter {
        void login(RequestBean requestBean, boolean isShowLoading);
    }


    interface loginView extends BaseView{
        void loginSucess(ResponseData<UserBean> data);
    }
}
