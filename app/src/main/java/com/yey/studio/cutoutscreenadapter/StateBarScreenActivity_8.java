package com.yey.studio.cutoutscreenadapter;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class StateBarScreenActivity_8 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_state_bar_screen);
        // 设置状态栏颜色透明
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        // 这个标记的意思是绘制一个背景透明的状态栏,然后用StatusBarColor中的颜色去填充,上面一步已经设置了StatusBarColor的颜色.
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // 最后还要清楚清除这个标记
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN: 视图延伸至状态栏区域，状态栏上浮于视图之上
        // SYSTEM_UI_FLAG_LIGHT_STATUS_BAR: 设置状态栏中字体与图标颜色为黑色.
        int flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        int visibility = getWindow().getDecorView().getSystemUiVisibility();
        visibility |= flags;// 追加属性
        getWindow().getDecorView().setSystemUiVisibility(visibility);

    }
}