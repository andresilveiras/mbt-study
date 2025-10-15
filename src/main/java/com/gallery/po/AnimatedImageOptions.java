package com.gallery.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AnimatedImageOptions extends BasePage{

    // Driver instanciation
    public AnimatedImageOptions(AndroidDriver driver) {
        super(driver);
        System.out.println("I'm on Folders Page");
        if(driver == null){
            System.out.println("Driver is null");
        }else{
            System.out.println("Driver is NOT null");
        }
    }

    // PAGE ELEMENTS

    @AndroidFindBy(id="org.fossify.gallery:id/gif_view")
    RemoteWebElement gifView;

    @AndroidFindBy(id="org.fossify.gallery:id/menu_properties")
    RemoteWebElement gifProperties;

    @AndroidFindBy(id="org.fossify.gallery:id/menu_rename")
    RemoteWebElement gifRename;

    @AndroidFindBy(id="org.fossify.gallery:id/bottom_favorite")
    RemoteWebElement gifFavorite;

    @AndroidFindBy(id="org.fossify.gallery:id/bottom_edit")
    RemoteWebElement gifEdit;

    @AndroidFindBy(id="org.fossify.gallery:id/bottom_share")
    RemoteWebElement gifShare;

    @AndroidFindBy(id="org.fossify.gallery:id/bottom_delete")
    RemoteWebElement gifDelete;

    // PAGE ACTIONS

    // Check that is in Animated Image Options Page --> Stay in the same page
    public boolean checkAnimatedImagePage(){
        System.out.println("Animated Image Options page check...");
        return gifView.isDisplayed();
    }

    public void viewFullScreen(){
        System.out.println("Click on image (Full Screen)");
        gifView.click();
    }

    // Go Back --> Go To Specific Folder
    public ListGifs goBackFromAnimatedImageOptions(){
        System.out.println("Going back from Animated Image Options.");
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
        // there was problem inspecting app's back button from this specific page, so we're using android's native
        return new ListGifs(driver);
    }

    // TODO: The next actions are only clicking and going back. Need to implement their real actions for complete test scenarios.

    public void renameGif(){
        System.out.println("Clicking on rename button.");
        gifRename.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

    public void viewGifProperties(){
        System.out.println("Clicking on gif properties.");
        gifProperties.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

    public boolean favoriteGif(boolean isFavorite){
        System.out.println("Clicking on favorite icon.");
        gifFavorite.click();
        isFavorite = !isFavorite;
        return isFavorite;
        // remember to update isFavorite variable in Main Test class.
        // example: isFavorite = AnimatedImageOptions.favoriteImage(isFavorite);
    }

    public void editGif(){
        System.out.println("Clicking on edit icon.");
        gifEdit.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

    public void shareGif(){
        System.out.println("Clicking on share icon.");
        gifShare.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

    public void deleteGif(){
        System.out.println("Clicking on delete icon.");
        gifDelete.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

}    