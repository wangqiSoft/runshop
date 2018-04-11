package com.runshoptechnology.runshop.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.BarUtils;
import com.flyco.systembar.SystemBarHelper;
import com.runshoptechnology.runshop.R;

import butterknife.ButterKnife;

/**
* @author Ryder
* create at 2018/4/6 10:55
* description: fragment 的基类
**/
public class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getContentViewLayoutID() != 0) {
            return inflater.inflate(getContentViewLayoutID(), container, false);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initView();
        SystemBarHelper.tintStatusBar(getActivity(), getResources().getColor(R.color.mainTabColor));
//        SystemBarHelper.immersiveStatusBar(this);
//        if (setTopView() != null) {
//            SystemBarHelper.setHeightAndPadding(this, setTopView());
//        }
    }

    public BaseFragment() {
    }

    protected int getContentViewLayoutID(){
        return 0;
    }

    /**
     *
     * 初始化界面
     */
    protected void initView(){

    }
    protected View setTopView() {
        return null;
    }
}
