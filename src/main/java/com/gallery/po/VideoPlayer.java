package com.gallery.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class VideoPlayer extends BasePage{

    // Driver instanciation
    public VideoPlayer(AndroidDriver driver) {
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

    @AndroidFindBy(id="org.fossify.gallery:id/video_toggle_play_pause")
    RemoteWebElement playPauseButton;

    @AndroidFindBy(id="org.fossify.gallery:id/video_playback_speed")
    RemoteWebElement playbackSpeedButton;

    @AndroidFindBy(id="org.fossify.gallery:id/video_toggle_mute")
    RemoteWebElement muteButton;

    @AndroidFindBy(id="org.fossify.gallery:id/video_curr_time")
    RemoteWebElement videoCurrentTime;

    @AndroidFindBy(id="org.fossify.gallery:id/video_duration")
    RemoteWebElement videoDurationTime;

    // PAGE ACTIONS

    public void viewVideoFullScreen(){
        System.out.println("Clicking on video (FullScreen)...");
        videoView.click();
    }

    public boolean changePlayStatus(boolean isPlaying){
        // video automatically pauses when video reaches duration time
        System.out.println("Checking if play time is over...");
        String now = videoCurrentTime.getText();
        String duration = videoDurationTime.getText();
        if(now.equals(duration)){
            System.out.println("Play time is over. Replaying video...");
            playPauseButton.click();
            isPlaying = true;
            return isPlaying;
        }else{
            if(isPlaying){
                System.out.println("Video is playing. Pausing video.");
                playPauseButton.click();
                return !isPlaying;
            }else{
                System.out.println("Video is Paused. Playing video...");
                playPauseButton.click();
                return !isPlaying;
            }
        } 
    }

    public VideoOptions goBackFromVideoPlayer(){
        System.out.println("Going back from video player");
        return new VideoOptions(driver);
        // video options are still available when video player is open
    }

    public boolean changeAudioStatus(boolean isMuted){
        if(isMuted){
            System.out.println("Video is Muted. Unmuting video...");
        }else{
            System.out.println("Video is Unmuted. Muting video...");
        }
        muteButton.click();
        return !isMuted;
    }

    // TODO: The next actions are only clicking and going back. Need to implement their real actions for complete test scenarios.

    public void changeVideoSpeed(){
        System.out.println("Changing video speed.");
        playbackSpeedButton.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
    }
}    