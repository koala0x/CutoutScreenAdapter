package com.yey.studio.cutoutscreenadapter.utils;

import android.content.Context;
import android.util.Log;

import java.lang.reflect.Method;

// Vivo Android O官方手机屏幕适配文档: https://dev.vivo.com.cn/documentCenter/doc/103
public class NotchUtils_Vivo_8 {

    /**
     * Vivo手机中,刘海高度要比状态栏高度要小一些
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
     * Vivo判断屏幕是否有刘海
     *
     * @param context
     * @return true 有刘海
     */
    public static final int VIVO_NOTCH = 0x00000020;//是否有刘海

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

    /**
     * Vivo判断屏幕是否有圆角
     *
     * @param context
     * @return true 有圆角
     */
    public static final int VIVO_FILLET = 0x00000008;//是否有圆角

    public static boolean hasFilletAtVivo(Context context) {
        boolean ret = false;
        try {
            ClassLoader classLoader = context.getClassLoader();
            Class FtFeature = classLoader.loadClass("android.util.FtFeature");
            Method method = FtFeature.getMethod("isFeatureSupport", int.class);
            ret = (boolean) method.invoke(FtFeature, VIVO_FILLET);
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
