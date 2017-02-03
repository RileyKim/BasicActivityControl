package com.taeksukim.android.activitycontrol;

import android.util.Log;

/**
 * @author  TaeksuKim
 * @Version 1.0
 * @sinece 2017. 1. 26..
 */

public class Logger {
    //DEbug MODE : 정상동작 안될경우 강제로 세팅한다.
    public final static boolean DEBUG_MODE = true;//BuildConfig.EDBUG;

    /**로그 내용을 콘솔에 출력
     *
     * @param string
     * @param className
     */
    public static void print(String string, String className) {

        if(DEBUG_MODE)
            Log.d(className, string);

    }
}
