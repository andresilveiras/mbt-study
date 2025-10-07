package com.gallery;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gallery.po.OpenPage;

import io.appium.java_client.android.AndroidDriver;

public class Main {
  
    /* 
     * ******************************************* 
     *              MAIN CLASS
     * ******************************************* 
     */

    public static void main(String[] args) throws IOException{


        AndroidDriver driver; 
        OpenPage welcomePage;

        try {
            driver = DriverRunner.createDriver();
            welcomePage = new OpenPage(driver);
            welcomePage.checkPermissionDialog();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }  
    }
}