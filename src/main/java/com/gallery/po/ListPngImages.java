package com.gallery.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ListPngImages extends BasePage{

    // Driver instanciation
    public ListPngImages(AndroidDriver driver) {
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

    // Check that is in list Png page --> Stay in the same page
    public boolean checkPngImagesPage(){
        System.out.println("List Png Images Page check...");
        return mediaGrid.isDisplayed();
    }

    // Check that the grid is not empty --> Stay in the same page
    public boolean checkPngItems(){
        System.out.println("Png Images Page not empty check...");
        return firstItem.isDisplayed();
    }

    // Click on first item --> Go to STATIC IMAGE OPTIONS
    public StaticImageOptions clickOnFirstItem(){
        System.out.println("Clicking on first Png Image...");
        firstItem.click();
        return new StaticImageOptions(driver);
    }

    // Go Back --> Go to LIST FOLDERS 
    public ListFolders goBackFromPngImages(){
        System.out.println("Going back from Png Images");
        backButton.click();
        return new ListFolders(driver);
    }

}    