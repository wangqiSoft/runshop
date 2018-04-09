package com.runshoptechnology.runshop.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.runshoptechnology.runshop.R;


/**
 * @author Ryder
 * create at 2018/4/9 23:33
 * package name:com.runshoptechnology.runshop.widget
 * description: 弹出拍照和从相册获取照片的PopupWindow
 **/

public class PhotoPopWindow extends PopupWindow {

    private TextView Camera;//拍照
    private TextView Album;//相册
    private Context MyContext;
    private Activity Myactivity;

    public PhotoPopWindow(Context context, Activity activity) {
        super(context);
        this.MyContext = context;
        this.Myactivity = activity;
        InitView();
    }

    private void InitView(){
        View parentView = LayoutInflater.from(MyContext).inflate(R.layout.pop_takefoto, null);
        //初始化PopupWindow对象,并为其设置宽高以及布局文件
        setContentView(parentView);
        //设置弹出窗体的高
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        parentView.setFocusable(true);
        parentView.setFocusableInTouchMode(true);
        Camera = (TextView) parentView.findViewById(R.id.erson_detail_camera);
        parentView.findViewById(R.id.person_detail_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取消
                PhotoPopWindow.this.dismiss();
            }
        });
        Album = (TextView) parentView.findViewById(R.id.person_detail_Album);
        //设置弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(false);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
    }

    /**
     * 设置打开相机界面的监听事件
     */
    public void SetCameraOnclick(View.OnClickListener listener){
        Camera.setOnClickListener(listener);
    }

    public void SetAlbumOnclick(View.OnClickListener listener){
        Album.setOnClickListener(listener);
    }

}
