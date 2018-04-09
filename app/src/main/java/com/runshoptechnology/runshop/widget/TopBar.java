package com.runshoptechnology.runshop.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.runshoptechnology.runshop.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Ryder
 * create at 2018/4/9 23:25
 * package name:com.runshoptechnology.runshop.wedgit
 * description: 头部布局
 **/
public class TopBar extends RelativeLayout {

    @BindView(R.id.topbarlayout)
    RelativeLayout topbarlayout;

    @BindView(R.id.left_button)
    ImageView leftButton;

    @BindView(R.id.left_txt)
    TextView leftTxt;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.right_txt)
    TextView rightTxt;

    private Context context;

    public TopBar(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }


    private void init() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.widget_topbar, this);
        ButterKnife.bind(this, view);
    }

    /**
     * 设置topBar的背景颜色
     *
     * @param colorid
     */
    public void setBackGround(int colorid) {
        topbarlayout.setBackgroundResource(colorid);
    }

    /**
     * 直接传入title
     *
     * @param name
     */
    public void setTitle(String name) {
        title.setText(name);
    }

    /**
     * 传入source id String.xml 中对应的
     *
     * @param resouce
     */
    public void setTitle(int resouce) {
        title.setText(context.getResources().getString(resouce));
    }


    /**
     * 设置左边按钮显示图片和点击事件
     *
     * @param resourceid 图片id
     * @param listener   点击事件
     */
    public void setLeftButtonListener(@NonNull int resourceid, @NonNull OnClickListener listener) {
        leftButton.setImageResource(resourceid);
        leftButton.setVisibility(View.VISIBLE);
        leftButton.setOnClickListener(listener);
    }

    /**
     * 设置左边按钮无图片
     */
    public void setLeftButtonNoPic() {
        leftButton.setVisibility(View.GONE);
    }

    /**
     * 设置右边文字按钮消失
     */
    public void setRightTextGone() {
        rightTxt.setVisibility(View.GONE);
    }

    /**
     * 设置右边按钮显示文本和点击事件
     *
     * @param txt
     * @param listener 点击事件
     */
    public void setRightTxtListener(@NonNull String txt, @NonNull OnClickListener listener) {
        rightTxt.setText(txt);
        rightTxt.setVisibility(View.VISIBLE);
        rightTxt.setOnClickListener(listener);
    }
    /**
     * 设置右边按钮显示文本
     *
     * @param txt
     */
    public void setRightTxt(@NonNull String txt) {
        rightTxt.setText(txt);
        rightTxt.setVisibility(View.VISIBLE);
    }

    /**
     * 设置右边按钮显示文本
     *
     * @param txt
     */
    public void setLeftTxt(@NonNull String txt) {
        leftTxt.setText(txt);
        leftTxt.setVisibility(View.VISIBLE);
    }

    /**
     * 设置右边按钮显示文本颜色
     *
     * @param colorid
     */
    public void setRightTxtColor(@NonNull int colorid) {
        ColorStateList color = getResources().getColorStateList(colorid);
        rightTxt.setTextColor(color);
        rightTxt.setVisibility(View.VISIBLE);
    }
    /**
     * 设置标题文本颜色
     *
     * @param colorid
     */
    public void setTitleColor(@NonNull int colorid) {
        ColorStateList color = getResources().getColorStateList(colorid);
        title.setTextColor(color);
    }

    public TextView getRightTxt() {
        return rightTxt;
    }
}
