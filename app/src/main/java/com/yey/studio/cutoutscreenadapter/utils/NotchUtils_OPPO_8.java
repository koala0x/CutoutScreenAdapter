package com.yey.studio.cutoutscreenadapter.utils;

import android.content.Context;
import android.util.Log;

import java.lang.reflect.Method;

// OPPO Android O 官方手机屏幕适配文档: https://open.oppomobile.com/wiki/doc#id=10159
public class NotchUtils_OPPO_8 {
    /**
     * 判断 OPPO 手机是否有刘海屏
     *
     * @param context
     * @return true 有刘海屏,false 没有刘海屏
     */
    public static boolean hasNotchInOppo(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    /**
     * OPPO手机中,刘海高度和状态栏的高度是一致的
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
     * Vivo判断是否有刘海， Vivo的刘海高度小于等于状态栏高度
     */
    public static final int VIVO_NOTCH = 0x00000020;//是否有刘海
    public static final int VIVO_FILLET = 0x00000008;//是否有圆角

    public static boolean hasNotchAtVivo(Context context) {
        boolean ret = false;
        try {
            ClassLoader classLoader = context.getClassLoader();
            Class FtFeature = classLoader.loadClass("android.util.FtFeature");
            Method method = FtFeature.getMethod("isFeatureSupport", int.class);
            ret = (boolean) method.invoke(FtFeature, VIVO_NOTCH);
        } catch (ClassNotFoundException e) {
            Log.e("Notch", "hasNotchAtVivo ClassNotFoundException");
        } catch (NoSuchMethodException e) {
            Log.e("Notch", "hasNotchAtVivo NoSuchMethodException");
        } catch (Exception e) {
            Log.e("Notch", "hasNotchAtVivo Exception");
        } finally {
            return ret;
        }
    }
}
