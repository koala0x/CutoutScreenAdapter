package com.yey.studio.cutoutscreenadapter;

import android.os.Build;
import android.os.Bundle;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class FullScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.设置全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // WindowManager.LayoutParams.FLAG_FULLSCREEN: 要求全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_full_screen);
        // 是否存在刘海屏
        boolean hasDisplayCutout = hasDisplayCutout(getWindow());
        if (hasDisplayCutout) {
            WindowManager.LayoutParams params = getWindow().getAttributes();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                // LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT 全屏模式，内容下移，非全屏不受影响
                // LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES 全屏模式,允许内容区域延伸进刘海区
                // LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER 全屏模式,不允许内容区域延伸进刘海区
                params.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            }
            getWindow().setAttributes(params);
            // 设置沉浸式,让内容延申到状态栏中
            int flags = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            int visibility = getWindow().getDecorView().getSystemUiVisibility();
            visibility |= flags;
            getWindow().getDecorView().setSystemUiVisibility(visibility);
        }
    }

    /**
     * 判断手机是否存在刘海屏
     *
     * @param window
     * @return
     */
    private boolean hasDisplayCutout(Window window) {
        DisplayCutout displayCutout;
        View rootView = window.getDecorView();
        WindowInsets insets = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            insets = rootView.getRootWindowInsets();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P && insets != null) {
            displayCutout = insets.getDisplayCutout();
            if (displayCutout != null) {
                if (displayCutout.getBoundingRects() != null && displayCutout.getBoundingRects().size() > 0 && displayCutout.getSafeInsetTop() > 0) {
                    return true;
                }
            }
        }
        // 模拟器上的一般是false,为了看效果返回true.
        return true;
    }
}