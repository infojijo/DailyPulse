package com.petros.efthymiou.dailypulse

import platform.Foundation.NSLog
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen

actual class Platform(){
    actual val osName: String
        get() = UIDevice.currentDevice().systemName
    actual val osVersion: String
        get() = UIDevice.currentDevice.systemVersion
    actual val deviceModel: String
        get() = UIDevice.currentDevice.model
    actual val deviceDensity: Int
        get() = UIScreen.mainScreen.scale.toInt()

    actual fun getDeviceDetails() {
        NSLog("Daily Pulse $osName, $osVersion, $deviceModel, $deviceDensity")
    }

}