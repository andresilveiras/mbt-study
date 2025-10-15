package com.gallery;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gallery.po.ListFolders;
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
        ListFolders listFolders;

        try {
            driver = DriverRunner.createDriver();
            welcomePage = new OpenPage(driver);
            listFolders = new ListFolders(driver);

            welcomePage.checkPermissionDialog();
            listFolders.checkFoldersPage();
            listFolders.clickOnStaticImageFolder();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        }  
    }
}