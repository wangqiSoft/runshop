package com.runshoptechnology.runshop.fragment;

import android.view.View;

import com.runshoptechnology.runshop.R;
import com.runshoptechnology.runshop.base.BaseFragment;
import com.runshoptechnology.runshop.widget.TopBar;

import butterknife.BindView;

/**
 * @author Ryder
 * create at 2018/4/10 11:58
 * package name:com.runshoptechnology.runshop.fragment
 * description: 热卖的fragment
 **/
public class HotFragment extends BaseFragment {
    @BindView(R.id.hot_fragment_topbar)
    TopBar hotTopbar;
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView() {
        super.initView();
        hotTopbar.setLeftButtonNoPic();
        hotTopbar.setTitle(R.string.hot_name);
        hotTopbar.setRightTextGone();
    }

    @Override
    protected View setTopView() {
        return hotTopbar;
    }

    public HotFragment() {
    }
}
