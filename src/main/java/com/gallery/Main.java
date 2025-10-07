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

        // Run Tests
        /*
        Executor executor = new TestExecutor(MainTest.class);

        Result result = executor.execute(true);
        if (result.hasErrors()) {
            for (String error : result.getErrors()) {
                System.out.println(error);
            }
        }
        */

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