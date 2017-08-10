package com.example.zhiyang.myapplication.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Zhiyang on 2017/8/10.
 */

public class GlobalData {

    private static final String sharePreferenceKey = "globalData";
    private static final int sharePreferenceMode = Context.MODE_PRIVATE;

    public static String usernameKey = "username";
    public static String emailKey = "email";

    public static void setSharePreferences(Context context, String key, String value) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(sharePreferenceKey, sharePreferenceMode);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(key, value);
            editor.commit();
        }
    }

    public static String getSharePreferences(Context context, String key) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(sharePreferenceKey, sharePreferenceMode);
            return sharedPreferences.getString(key, null);
        } else {
            return null;
        }
    }

    public static boolean isLogin(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharePreferenceKey, sharePreferenceMode);
        return sharedPreferences.contains(emailKey);
    }

}
