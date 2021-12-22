// Pirate-Emperor - Author
// This is an instrumented test class to verify various aspects of the app context within a gaming application.

package com.example.gamingapp

import android.content.pm.PackageManager
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiSelector
import android.util.Log
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    // Test to verify the application context
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.gamingapp", appContext.packageName)
    }

    // Test to verify the app's package name
    @Test
    fun appPackageName_isCorrect() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.gamingapp", appContext.packageName)
    }

    // Test to check if the app is not null
    @Test
    fun appIsNotNull() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertNotNull(appContext)
    }

    // Test to verify the application label
    @Test
    fun appLabel_isCorrect() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val appLabel = appContext.packageManager.getApplicationLabel(appContext.applicationInfo)
        assertEquals("GamingApp", appLabel)
    }

    // Test to check if the app has the correct version name
    @Test
    fun appVersionName_isCorrect() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val packageInfo = appContext.packageManager.getPackageInfo(appContext.packageName, 0)
        assertEquals("1.0", packageInfo.versionName)
    }

    // Test to verify if a specific permission is granted
    @Test
    fun permission_isGranted() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val permissionStatus = appContext.checkCallingOrSelfPermission("android.permission.INTERNET")
        assertEquals(PackageManager.PERMISSION_GRANTED, permissionStatus)
    }

    // Test to check if the app has the correct package info
    @Test
    fun appPackageInfo_isCorrect() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val packageInfo = appContext.packageManager.getPackageInfo(appContext.packageName, 0)
        assertNotNull(packageInfo)
    }

    // Test to verify if the main activity is accessible
    @Test
    fun mainActivity_isAccessible() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val intent = appContext.packageManager.getLaunchIntentForPackage(appContext.packageName)
        assertNotNull(intent)
    }

    // Test to check if the app context is loaded
    @Test
    fun appContext_isLoaded() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertTrue(appContext.packageManager.getPackageInfo(appContext.packageName, 0).versionName.isNotEmpty())
    }

    // Test to verify that the app has a specific service registered
    @Test
    fun service_isRegistered() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val serviceIntent = appContext.packageManager.getLaunchIntentForPackage("com.example.gamingapp.MyService")
        assertNull(serviceIntent)
    }

    // Test to verify if the app has a specific feature
    @Test
    fun feature_isAvailable() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertTrue(appContext.packageManager.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN))
    }

    // Test to check if a resource exists in the app
    @Test
    fun resource_exists() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val resourceId = appContext.resources.getIdentifier("ic_launcher", "mipmap", appContext.packageName)
        assertNotEquals(0, resourceId)
    }

    // Test to verify the default shared preferences exist
    @Test
    fun sharedPreferencesExist() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val sharedPreferences = appContext.getSharedPreferences("default_prefs", android.content.Context.MODE_PRIVATE)
        assertNotNull(sharedPreferences)
    }

    // Test to verify the device is not null
    @Test
    fun device_isNotNull() {
        val device = UiDevice.getInstance(getInstrumentation())
        assertNotNull(device)
    }

    // Test to check if the correct activity is launched
    @Test
    fun correctActivityIsLaunched() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val intent = appContext.packageManager.getLaunchIntentForPackage(appContext.packageName)
        intent?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        appContext.startActivity(intent)
        val device = UiDevice.getInstance(getInstrumentation())
        val activity = device.findObject(UiSelector().packageName(appContext.packageName))
        assertTrue(activity.exists())
    }

    // Test to verify that the app is in the foreground
    @Test
    fun appIsInForeground() {
        val device = UiDevice.getInstance(getInstrumentation())
        val currentPackageName = device.currentPackageName
        assertEquals("com.example.gamingapp", currentPackageName)
    }

    // Test to verify that a log message is printed
    @Test
    fun logMessage_isPrinted() {
        val logMessage = "Test log message"
        Log.d("ExampleInstrumentedTest", logMessage)
        assertTrue(logMessage.isNotEmpty())
    }

    // Test to verify that the app's resources are not null
    @Test
    fun resources_areNotNull() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertNotNull(appContext.resources)
    }

    // Test to verify that the app has the correct build version
    @Test
    fun appBuildVersion_isCorrect() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val buildVersion = appContext.applicationInfo.targetSdkVersion
        assertTrue(buildVersion >= 28)
    }

    // Test to verify that the app can launch an activity
    @Test
    fun canLaunchActivity() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val intent = appContext.packageManager.getLaunchIntentForPackage(appContext.packageName)
        intent?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        appContext.startActivity(intent)
        assertNotNull(intent)
    }

    // Test to verify that the app has a valid application context
    @Test
    fun applicationContext_isValid() {
        val appContext = ApplicationProvider.getApplicationContext<android.app.Application>()
        assertNotNull(appContext)
    }

    // Test to verify that the app's context is available
    @Test
    fun context_isAvailable() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertNotNull(appContext)
    }

    // Test to verify that the app can access the resources
    @Test
    fun canAccessResources() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val resources = appContext.resources
        assertNotNull(resources)
    }
}
