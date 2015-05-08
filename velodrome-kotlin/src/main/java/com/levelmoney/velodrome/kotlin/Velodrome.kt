package com.levelmoney.velodrome.kotlin

import android.app.Activity
import android.content.Intent
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import com.levelmoney.velodrome.annotations.Result
import com.levelmoney.velodrome.handlers.ActivityResultHandler
import com.levelmoney.velodrome.handlers.DialogFragmentResultHandler

/**
 * Created by Aaron Sarazan on 5/7/15
 * Copyright(c) 2015 Level, Inc.
 */

/**
 * [Result(SOME_CODE)]
 * val aLauncher = activityLauncher(SOME_CODE, javaClass<SomeActivity>()) {
 *   Log.d(TAG, it.getStringExtra("result")
 * }
 */
public fun Fragment.activityLauncher(requestCode: Int, clazz: Class<out Activity>, handler: (Intent?) -> Unit): ActivityResultHandler {
    return object: ActivityResultHandler(this, requestCode, clazz) {
        override fun handleResult(data: Intent?) {
            handler(data)
        }
    }
}

/**
 * [Result(SOME_CODE)]
 * val aLauncher = activityLauncher(SOME_CODE, javaClass<SomeActivity>()) {
 *   Log.d(TAG, it.getStringExtra("result")
 * }
 */
public fun Activity.activityLauncher(requestCode: Int, clazz: Class<out Activity>, handler: (Intent?) -> Unit): ActivityResultHandler {
    return object: ActivityResultHandler(this, requestCode, clazz) {
        override fun handleResult(data: Intent?) {
            handler(data)
        }
    }
}

/**
 * [Result(SOME_CODE)]
 * val dLauncher = dialogLauncher(SOME_CODE, javaClass<SomeDFragment>()) {
 *   Log.d(TAG, it.getStringExtra("result")
 * }
 */
public fun Fragment.dialogLauncher(requestCode: Int, clazz: Class<out DialogFragment>, handler: (Intent?) -> Unit): DialogFragmentResultHandler {
    return object: DialogFragmentResultHandler(this, requestCode, clazz) {
        override fun handleResult(data: Intent?) {
            handler(data)
        }
    }
}