package com.runshoptechnology.runshop.ui;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;

import com.runshoptechnology.runshop.R;
import com.runshoptechnology.runshop.adapter.MainPagerAdapter;
import com.runshoptechnology.runshop.base.BaseActivity;
import com.runshoptechnology.runshop.base.BasePresenter;
import com.runshoptechnology.runshop.fragment.ChartFragment;
import com.runshoptechnology.runshop.fragment.HomeFragment;
import com.runshoptechnology.runshop.fragment.HotFragment;
import com.runshoptechnology.runshop.fragment.MeFragment;
import com.runshoptechnology.runshop.fragment.SearchFragment;
import com.runshoptechnology.runshop.utils.ActivityManager;
import com.wangqiSoft.tablayout.CommonTabLayout;
import com.wangqiSoft.tablayout.listener.CustomTabEntity;
import com.wangqiSoft.tablayout.listener.OnTabSelectListener;
import com.wangqiSoft.tablayout.listener.impl.TabEntity;

import java.util.ArrayList;

import butterknife.BindView;
import es.dmoral.toasty.Toasty;

/**
 * @author Ryder
 * create at 2018/4/9 23:16
 * package name:com.runshoptechnology.runshop.ui
 * description: 主界面
 **/
public class MainActivity extends BaseActivity {

    @BindView(R.id.main_tablayout)
    CommonTabLayout mMainTablayout;
    @BindView(R.id.main_vp)
    ViewPager mMainVp;

    private String[] mTitles =  new String[]{"主页", "热卖","搜索","购物车","我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.home_unselect, R.mipmap.hot_unselect,
            R.mipmap.search_unselect,R.mipmap.chart_unselect,R.mipmap.me_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.home_select, R.mipmap.hot_select,
            R.mipmap.search_select,R.mipmap.chart_select,R.mipmap.me_select};
    private ArrayList<Fragment> mFragments = new ArrayList<>(5);
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>(5);
    private HomeFragment homeFragment = new HomeFragment();
    private HotFragment hotFragment = new HotFragment();
    private SearchFragment searchFragment = new SearchFragment();
    private ChartFragment chartFragment = new ChartFragment();
    private MeFragment meFragment = new MeFragment();
    private MainPagerAdapter mainPagerAdapter;// viewpager的adapter
    public static int currentPos = 0; //主选项卡位置


    @Override
    protected int getlayoutContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter generatePresenter() {
        return null;
    }

    @Override
    protected View setTopView() {
        return super.setTopView();
    }

    @Override
    protected void initView() {
        super.initView();
        mFragments.add(homeFragment);
        mFragments.add(hotFragment);
        mFragments.add(searchFragment);
        mFragments.add(chartFragment);
        mFragments.add(meFragment);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

        mMainTablayout.setTabData(mTabEntities);
        mMainTablayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mMainVp.setCurrentItem(position, true);
//                if (position == 1 || position == 3) mMainTablayout.hideMsg(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mMainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPos = position;
                mMainTablayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mainPagerAdapter =  new MainPagerAdapter(getSupportFragmentManager(),mFragments,mTitles);
        mMainVp.setAdapter(mainPagerAdapter);
        mMainVp.setOffscreenPageLimit(3);
        mMainVp.setCurrentItem(0);
    }

    //控制物理返回键
    // 用来计算返回键的点击间隔时间
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            if (System.currentTimeMillis() - exitTime > 2000) {
                Toasty.success(this, getResources().getString(R.string.sys_exit_tips)).show();
                exitTime = System.currentTimeMillis();
            } else {
                ActivityManager.getInstance().finishAllActivity();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
