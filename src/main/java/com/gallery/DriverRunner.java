package com.gallery;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

/* 
    * ******************************************* 
    * CLASS OF SETUP CAPABILITIES FOR APPIUM V2
    * ******************************************* 
*/

public class DriverRunner {

    // Define driver
    public static AndroidDriver driver;

    // CREATE DRIVER
    public static AndroidDriver createDriver() throws MalformedURLException{

        // Define variables for appium device capabilities

        String deviceName = "moto g(20)";
        String deviceUdid = "0076732961";
        String deviceOS = "Android";
        String deviceOSVersion = "11";
        String deviceAutomation = "uiautomator2";

        // Now the SUT - system under test - capabilities

        //this is the path of where the SUT is located in your machine, not in the device
        String appPath = "Documents/GitHub/mbt-study/src/main/resources/fossify_gallery_v1-5-2.apk";
        String appPackage = "org.fossify.gallery";
        String appActivity1 = "org.fossify.gallery.activities.MainActivity";

        String appiumServerURL = "http://127.0.0.1:4723";

        // Setting up the capabilities

        UiAutomator2Options capability = new UiAutomator2Options()

        // DEVICE SETUP
        .setDeviceName(deviceName)
        .setUdid(deviceUdid)
        .setAutomationName(deviceAutomation)
        .setPlatformName(deviceOS)
        .setPlatformVersion(deviceOSVersion)

        // SUT SETUP
        .setApp(appPath)
        .setAppPackage(appPackage)
        .setAppActivity(appActivity1)
        .setNoReset(false);

        // Connect Capabilities to Appium Server
        URL url = new URL(appiumServerURL);
        AndroidDriver driver = new AndroidDriver(url, capability);

        System.out.println("App started");

        return driver;

    }
/*
    //Kill Driver
    public static void killDriver(){
        if (driver != null){
            driver.close();
            driver = null;
        }
    }
*/
}
