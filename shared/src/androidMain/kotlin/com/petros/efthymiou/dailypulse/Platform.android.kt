package com.petros.efthymiou.dailypulse

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

actual class Platform() {
    actual val osName: String
        get() = "Android"
    actual val osVersion: String
        get() = "${Build.VERSION.SDK_INT}"
    actual val deviceModel: String
        get() = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val deviceDensity: Int
        get() = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun getDeviceDetails() {
        Log.d("Daily Pulse Log", "$osName, $osVersion, $deviceModel, $deviceDensity")
    }
}