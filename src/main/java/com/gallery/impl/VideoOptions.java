package com.gallery.impl;

import com.gallery.model.VideoOptionsInterface;

public class VideoOptions implements VideoOptionsInterface{
    
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
    public void v_RenameVideo(){
        System.out.println("I'm on vertex RENAME VIDEO");
    }

    @Override
    public void v_EditVideo(){
        System.out.println("I'm on vertex EDIT VIDEO");
    }
    
    @Override
    public void v_OpenVideoOptions(){
        System.out.println("I'm on vertex OPEN VIDEO OPTIONS");
    }

    @Override
    public void v_CheckName(){
        System.out.println("I'm on vertex CHECK NAME");
    }

    @Override
    public void v_OpenVideoProperties(){
        System.out.println("I'm on vertex OPEN VIDEO PROPERTIES");
    }

    @Override
    public void v_ShareVideo(){
        System.out.println("I'm on vertex SHARE VIDEO");
    }

    /* 
    * ******************************************* 
    *             Events / Edges
    * ******************************************* 
    */

    @Override
    public void e_TypeNewName(){
        System.out.println("I'm on edge TYPE NEW NAME");
    }

    @Override
    public void e_GoBackFromRename(){
        System.out.println("I'm on edge GO BACK FROM RENAME");

    }


    @Override
    public void e_ClickOnRenameIcon(){
        System.out.println("I'm on edge CLICK ON RENAME ICON");

    }

    @Override
    public void e_ClickOnShareIcon(){
        System.out.println("I'm on edge CLICK ON SHARE ICON");

    }

    @Override
    public void e_GoBackFromPlayer(){
        System.out.println("I'm on edge GO BACK FROM PLAYER");


    }


    @Override
    public void e_DiscardNewName(){
        System.out.println("I'm on edge DISCARD NEW NAME");


    }


    @Override
    public void e_ClickOnPlayIcon(){
        System.out.println("I'm on edge CLICK ON PLAY ICON");

    }

    @Override
    public void e_ClickOK(){
        System.out.println("I'm on edge CLICK OK");

    }


    @Override
    public void e_GoBackFromSharing(){
        System.out.println("I'm on edge GO BACK FROM SHARING");

    }

    @Override
    public void e_ClickOnInfoIcon(){
        System.out.println("I'm on edge CLICK ON INFO ICON");

    }

    @Override
    public void e_GoBackFromEdition(){
        System.out.println("I'm on edge GO BACK FROM EDITION");

    }

    @Override
    public void e_SaveNewName(){
        System.out.println("I'm on edge SAVE NEW NAME");

    }

    @Override
    public void e_ClickOnEditIcon(){
        System.out.println("I'm on edge CLICK ON EDIT ICON");

    }
}
