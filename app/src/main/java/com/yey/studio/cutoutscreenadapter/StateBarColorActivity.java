package com.yey.studio.cutoutscreenadapter;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 为状态栏设置颜色,5.0 6.0 7.0 8.0 9.0 都适用,不支持5.0以下
 */
public class StateBarColorActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_state_bar_screen);
        // 首先设置状态栏的颜色
        getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
        // 这个标记的意思是绘制一个背景透明的状态栏,然后用StatusBarColor中的颜色去填充,上面一步已经设置了StatusBarColor的颜色
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // 最后还要清楚清除这个标记
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
}