package com.gallery.impl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import com.gallery.model.VideoPlayer;

@GraphWalker(value = "random(edge_coverage(100))")
public class VideoPlayerImpl extends ExecutionContext implements VideoPlayer{

    /* 
    * ******************************************* 
    *             States / Vertex
    * ******************************************* 
    */  

    @Override
    public void v_OpenVideoPlayer(){
        System.out.println("I'm on vertex OPEN VIDEO PLAYER");
    }

    @Override
    public void v_ChangePlayStatus(){
        System.out.println("I'm on vertex CHANGE PLAY STATUS");
    }

    @Override
    public void v_MuteAudio(){
        System.out.println("I'm on vertex MUTE AUDIO");
    }

    @Override
    public void v_ViewFullScreen(){
        System.out.println("I'm on vertex VIEW FULL SCREEN");
    }

    @Override
    public void v_PlaybackSpeed(){
        System.out.println("I'm on vertex PLAYBACK SPEED");
    }

    /* 
    * ******************************************* 
    *             Events / Edges
    * ******************************************* 
    */

    @Override
    public void e_ClickOnPauseIcon(){
        System.out.println("I'm on edge CLICK ON PAUSE ICON");
    
    }

    @Override
    public void e_ClickOnPlayIcon(){
        System.out.println("I'm on edge CLICK ON PLAY ICON");
    
    }

    @Override
    public void e_ClickOnMuteIcon(){
        System.out.println("I'm on edge CLICK ON MUTE ICON");
    }

    @Override
    public void e_ClickOnUnmuteIcon(){
        System.out.println("I'm on edge CLICK ON UNMUTE ICON");
    }

    @Override
    public void e_ClickOnVideo(){
        System.out.println("I'm on edge CLICK ON VIDEO");
    }

    @Override
    public void e_ClickOnScreen(){
        System.out.println("I'm on edge CLICK ON SCREEN");
    }

    @Override
    public void e_ClickOnSpeedIcon(){
        System.out.println("I'm on edge CLICK ON SPEED ICON");
    }

    @Override
    public void e_SelectSpeed(){
        System.out.println("I'm on edge SELECT SPEED");
    }

    @Override
    public void e_SaveChanges(){
        System.out.println("I'm on edge SAVE CHANGES");
    }


    @Override
    public void e_DiscardChanges(){
        System.out.println("I'm on edge DISCARD CHANGES");
    }

}