package com.gallery.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class StaticImageOptions extends BasePage{

    // Driver instanciation
    public StaticImageOptions(AndroidDriver driver) {
        super(driver);
        System.out.println("I'm on Folders Page");
        if(driver == null){
            System.out.println("Driver is null");
        }else{
            System.out.println("Driver is NOT null");
        }
    }

    // PAGE ELEMENTS

    @AndroidFindBy(id="org.fossify.gallery:id/subsampling_view")
    RemoteWebElement imageView;

    @AndroidFindBy(id="org.fossify.gallery:id/menu_rotate")
    RemoteWebElement imageRotation;

    @AndroidFindBy(id="org.fossify.gallery:id/menu_properties")
    RemoteWebElement imageProperties;

    @AndroidFindBy(id="org.fossify.gallery:id/bottom_favorite")
    RemoteWebElement imageFavorite;

    @AndroidFindBy(id="org.fossify.gallery:id/bottom_edit")
    RemoteWebElement imageEdition;

    @AndroidFindBy(id="org.fossify.gallery:id/bottom_share")
    RemoteWebElement imageSharing;

    @AndroidFindBy(id="org.fossify.gallery:id/bottom_delete")
    RemoteWebElement imageDelete;

    // PAGE ACTIONS

    // Check that is in Static Image Options Page --> Stay in the same page
    public boolean checkJpegImagesPage(){
        System.out.println("Static Image Options page check...");
        return imageView.isDisplayed();
    }

    // Go Back --> Go To Specific Folder
    public ListStaticImages goBackFromStaticImageOptions(){
        System.out.println("Going back from Static Image Options.");
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
        // there was problem inspecting app's back button from this specific page, so we're using android's native
        return new ListStaticImages(driver);
    }

    // TODO: The next actions are only clicking and going back. Need to implement their real actions for complete test scenarios.

    public void rotateImage(){
        System.out.println("Clicking on rotation button.");
        imageRotation.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

    public void viewImageProperties(){
        System.out.println("Clicking on image properties.");
        imageProperties.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

    public boolean favoriteImage(boolean isFavorite){
        System.out.println("Clicking on favorite icon.");
        imageFavorite.click();
        isFavorite = !isFavorite;
        return isFavorite;
        // remember to update isFavorite variable in Main Test class.
        // example: isFavorite = StaticImageOptions.favoriteImage(isFavorite);
    }

    public void editImage(){
        System.out.println("Clicking on edit icon.");
        imageEdition.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

    public void shareImage(){
        System.out.println("Clicking on share icon.");
        imageSharing.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

    public void deleteImage(){
        System.out.println("Clicking on delete icon.");
        imageDelete.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

}    