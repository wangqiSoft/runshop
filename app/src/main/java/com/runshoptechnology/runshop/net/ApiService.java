package com.runshoptechnology.runshop.net;

import com.runshoptechnology.runshop.bean.RequestBean;
import com.runshoptechnology.runshop.bean.ResponseData;
import com.runshoptechnology.runshop.bean.UserBean;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 接口地址
 */

public interface ApiService {

    //登录
    @POST("auth/login")
    Flowable<ResponseData<UserBean>> Login(@Body RequestBean body);

}
