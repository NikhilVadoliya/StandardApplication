package com.sp.standardapplication.helper;

/**
 * Copyright (c) 2015-2016 Sailfin Technologies, Pvt. Ltd.  All Rights Reserved.
 * This software is the confidential and proprietary information
 * (Confidential Information) of Sailfin Technologies, Pvt. Ltd.  You shall not
 * disclose or use Confidential Information without the express written
 * agreement of Sailfin Technologies, Pvt. Ltd.
 */

import android.util.Log;

/**
 * Created by nikhil.vadoliya on 31-08-2017.
 */


public class StandLog {

    public static void v(String tag, String msg) {
        if (Constants.IS_LOG_ENABLED)
            Log.v(tag, msg);
    }

    public static void v(String tag, String msg, Throwable tr) {
        if (Constants.IS_LOG_ENABLED)
            Log.v(tag,msg);
    }

    public static void d(String tag, String msg) {
        if (Constants.IS_LOG_ENABLED)
            Log.d(tag, msg);
    }

    public static void d(String tag, String msg, Throwable tr) {
        if (Constants.IS_LOG_ENABLED)
            Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (Constants.IS_LOG_ENABLED)
            Log.i(tag, msg);
    }

    public static void i(String tag, String msg, Throwable tr) {
        if (Constants.IS_LOG_ENABLED)
            Log.i(tag,msg);
    }

    public static void w(String tag, String msg) {
        if (Constants.IS_LOG_ENABLED)
            Log.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (Constants.IS_LOG_ENABLED)
            Log.e(tag, msg);
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (Constants.IS_LOG_ENABLED)
            Log.e(tag,msg);
    }
}