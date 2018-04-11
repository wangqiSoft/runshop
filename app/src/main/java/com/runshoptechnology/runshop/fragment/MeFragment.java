package com.runshoptechnology.runshop.fragment;

import android.view.View;

import com.runshoptechnology.runshop.R;
import com.runshoptechnology.runshop.base.BaseFragment;
import com.runshoptechnology.runshop.widget.TopBar;

import butterknife.BindView;

/**
 * @author Ryder
 * create at 2018/4/10 12:02
 * package name:com.runshoptechnology.runshop.fragment
 * description:
 **/
public class MeFragment extends BaseFragment {
    @BindView(R.id.me_topbar)
    TopBar meTopbar;

    public MeFragment() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {
        super.initView();
        meTopbar.setLeftButtonNoPic();
        meTopbar.setTitle(R.string.me_name);
        meTopbar.setRightTextGone();
    }

    @Override
    protected View setTopView() {
        return meTopbar;
    }
}
