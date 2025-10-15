package com.gallery.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ListVideos extends BasePage{

    // Driver instanciation
    public ListVideos(AndroidDriver driver) {
        super(driver);
        System.out.println("I'm on Folders Page");
        if(driver == null){
            System.out.println("Driver is null");
        }else{
            System.out.println("Driver is NOT null");
        }
    }

    // PAGE ELEMENTS

    @AndroidFindBy(id="org.fossify.gallery:id/media_grid")
    RemoteWebElement mediaGrid;

    @AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"org.fossify.gallery:id/medium_thumbnail\").instance(0)")
    RemoteWebElement firstItem;

    @AndroidFindBy(id="org.fossify.gallery:id/top_toolbar_search_icon")
    RemoteWebElement backButton;

    // PAGE ACTIONS

    // Check that is in list JPEG page --> Stay in the same page
    public boolean checkVideosPage(){
        System.out.println("List Videos Page check...");
        return mediaGrid.isDisplayed();
    }

    // Check that the grid is not empty --> Stay in the same page
    public boolean checkVideoItems(){
        System.out.println("Videos Page not empty check...");
        return firstItem.isDisplayed();
    }

    // Click on first item --> Go to STATIC IMAGE OPTIONS
    public VideoOptions clickOnFirstItem(){
        System.out.println("Clicking on first Video...");
        firstItem.click();
        return new VideoOptions(driver);
    }

    // Go Back --> Go to LIST FOLDERS 
    public ListFolders goBackFromVideos(){
        System.out.println("Going back from Videos");
        backButton.click();
        return new ListFolders(driver);
    }

}    