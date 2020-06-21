package com.yey.studio.cutoutscreenadapter.utils;

import android.content.Context;

import java.lang.reflect.Method;

// 小米 Android O 官方手机屏幕适配文档: https://dev.mi.com/console/doc/detail?pId=1293
public class NotchUtils_XiaoMi_8 {

    /**
     * 小米手机中,刘海屏状态栏高度与正常手机的不同,不建议写固定值,应该动态获取.
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int resId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            return context.getResources().getDimensionPixelSize(resId);
        }
        return 0;
    }

    /**
     * 小米手机判断屏幕是否有刘海
     *
     * @return true 有刘海
     */
    public static boolean hasNotchAtXiaoMi() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method getMethod = cls.getMethod("getInt", String.class, int.class);
            int defaultVal = (Integer) getMethod.invoke(cls, "ro.miui.notch", 0);
            if (defaultVal == 1) {
                return true;
            } else if (defaultVal == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return false;
        }
    }

    /**
     * 获取屏幕中刘海宽高尺寸
     * int[0]值为刘海宽度
     * int[1]值为刘海高度
     *
     * @param context
     * @return
     */
    public static int[] getNotchSize(Context context) {
        int[] ret = new int[]{0, 0};
        int resourceWidthId = context.getResources().getIdentifier("notch_width", "dimen", "android");
        if (resourceWidthId > 0) {
            ret[0] = context.getResources().getDimensionPixelSize(resourceWidthId);
        }
        int resourceHeightId = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (resourceHeightId > 0) {
            ret[1] = context.getResources().getDimensionPixelSize(resourceHeightId);
        }
        return ret;
    }
}
