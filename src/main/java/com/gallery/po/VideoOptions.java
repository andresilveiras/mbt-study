package com.gallery.po;

import io.appium.java_client.android.AndroidDriver;

public class VideoOptions extends BasePage{

    // Driver instanciation
    public VideoOptions(AndroidDriver driver) {
        super(driver);
        System.out.println("I'm on Folders Page");
        if(driver == null){
            System.out.println("Driver is null");
        }else{
            System.out.println("Driver is NOT null");
        }
    }

    // PAGE ELEMENTS

    // PAGE ACTIONS

}    