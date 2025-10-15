package com.gallery.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ListFolders extends BasePage{

    // Driver instanciation
    public ListFolders(AndroidDriver driver) {
        super(driver);
        System.out.println("I'm on Folders Page");
        if(driver == null){
            System.out.println("Driver is null");
        }else{
            System.out.println("Driver is NOT null");
        }
    }

    // PAGE ELEMENTS

    @AndroidFindBy(id="org.fossify.gallery:id/directories_grid")
    RemoteWebElement foldersGrid;

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Animais (jpeg)\")")
    RemoteWebElement folderJpeg;

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Edifícios (PNG)\")")
    RemoteWebElement folderPng;

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Esculturas (webp)\")")
    RemoteWebElement folderWebp;

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Videos\")")
    RemoteWebElement folderVideos;

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"GIFs\")")
    RemoteWebElement folderGifs;

    // PAGE ACTIONS:

    // Check that is in main page --> Stay in the same page
    public boolean checkFoldersPage(){
        System.out.println("List Folders Page check...");
        return foldersGrid.isDisplayed();
    }

    // ------------------------
    // Static Images Folders:
    // ------------------------

    // Click on Images JPEG --> Go to LIST JPEG IMAGES
    public ListJpegImages clickOnJpegFolder(){
        System.out.println("Clicking on JPEG Images Folder...");
        folderJpeg.click();
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));
        return new ListJpegImages(driver);
    }

    // Click on Images PNG --> Go to LIST PNG IMAGES
    public ListPngImages clickOnPngFolder(){
        System.out.println("Clicking on PNG Images Folder...");
        folderPng.click();
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));
        return new ListPngImages(driver);
    }

    // Click on Images WEBP --> Go to LIST WEBP IMAGES
    public ListWebpImages clickOnWebpFolder(){
        System.out.println("Clicking on WEBP Images Folder...");
        folderWebp.click();
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));
        return new ListWebpImages(driver);
    }

    // ------------------------
    // Videos Folders:
    // ------------------------

    // Click on Videos --> Go to LIST VIDEOS
    public ListVideos clickOnVideosFolder(){
        System.out.println("Clicking on Videos Folder...");
        folderVideos.click();
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));
        return new ListVideos(driver);
    }

    // ------------------------
    // Animated Images Folders:
    // ------------------------

    // Click on Gifs --> Go to LIST GIFS
    public ListGifs clickOnGifsFolder(){
        System.out.println("Clicking on Gifs Folder...");
        folderGifs.click();
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));
        return new ListGifs(driver);
    }    
  
}
