package com.gallery.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

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

    @AndroidFindBy(id="org.fossify.gallery:id/video_surface_frame")
    RemoteWebElement videoView;

    @AndroidFindBy(id="org.fossify.gallery:id/video_play_outline")
    RemoteWebElement firstPlayIcon;

    @AndroidFindBy(id="org.fossify.gallery:id/menu_properties")
    RemoteWebElement videoProperties;

    @AndroidFindBy(id="org.fossify.gallery:id/menu_rename")
    RemoteWebElement videoRename;

    @AndroidFindBy(id="org.fossify.gallery:id/bottom_favorite")
    RemoteWebElement videoFavorite;

    @AndroidFindBy(id="org.fossify.gallery:id/bottom_edit")
    RemoteWebElement videoEdit;

    @AndroidFindBy(id="org.fossify.gallery:id/bottom_share")
    RemoteWebElement videoShare;

    @AndroidFindBy(id="org.fossify.gallery:id/bottom_delete")
    RemoteWebElement videoDelete;

    // PAGE ACTIONS

    // PAGE ACTIONS

    // Check that is in Video Options Page --> Stay in the same page
    public boolean checkVideoPage(){
        System.out.println("Video Options page check...");
        return videoView.isDisplayed();
    }

    // Go Back --> Go To Specific Folder
    public ListVideos goBackFromVideoOptions(){
        System.out.println("Going back from Video Options.");
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
        // there was problem inspecting app's back button from this specific page, so we're using android's native
        return new ListVideos(driver);
    }

    // Play video --> Open Video Player
    public VideoPlayer playVideo(){
        System.out.println("Playing video...");
        firstPlayIcon.click();
        return new VideoPlayer(driver);
    }

    // TODO: The next actions are only clicking and going back. Need to implement their real actions for complete test scenarios.

    public void videoProperties(){
        System.out.println("Clicking on Properties Icon");
        videoProperties.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

    public void renameVideo(){
        System.out.println("Clicking on Rename Icon");
        videoRename.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

    public boolean favoriteVideo(boolean isFavorite){
        System.out.println("Clicking on Favorite Icon");
        videoFavorite.click();
        isFavorite = !isFavorite;
        return isFavorite;
    }

    public void editVideo(){
        System.out.println("Clicking on Edit Icon");
        videoEdit.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

    public void shareVideo(){
        System.out.println("Clicking on Share Icon");
        videoShare.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

    public void deleteVideo(){
        System.out.println("Clicking on Delete Icon");
        videoDelete.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }

}    