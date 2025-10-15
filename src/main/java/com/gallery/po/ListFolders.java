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

    // Check that is in main page --> Stay in the same page
    public void clickOnStaticImageFolder(){
        System.out.println("Click Image Folders check...");
        folderJpeg.click();
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }
  
}
