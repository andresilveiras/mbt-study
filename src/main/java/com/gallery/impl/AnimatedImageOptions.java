package com.gallery.impl;

import com.gallery.model.AnimatedImageOptionsInterface;

public class AnimatedImageOptions implements AnimatedImageOptionsInterface {

    /* 
    * ******************************************* 
    *             States / Vertex
    * ******************************************* 
    */    

    @Override
    public void v_EditImage(){
        System.out.println("I'm on vertex EDIT IMAGE");


    }    
    
    @Override
    public void v_ShareImage(){
        System.out.println("I'm on vertex SHARE IMAGE");


    }

    @Override
    public void v_RenameImage(){
        System.out.println("I'm on vertex RENAME IMAGE");


    }

    @Override
    public void v_CheckName(){
        System.out.println("I'm on vertex CHECK NAME");


    }

    @Override
    public void v_OpenImageProperties(){
        System.out.println("I'm on vertex OPEN IMAGE PROPERTIES");



    }

    @Override
    public void v_ViewImageFullScreen(){
        System.out.println("I'm on vertex VIEW IMAGE FULL SCREEN");



    }

    @Override
    public void v_OpenAnimatedImage(){
        System.out.println("I'm on vertex OPEN ANIMATED IMAGE");


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
    public void e_ClickOnEditionIcon(){
        System.out.println("I'm on edge CLICK ON EDITION ICON");



    }

    @Override
    public void e_GoBackFromRename(){
        System.out.println("I'm on edge GO BACK FROM RENAME");


    }

    @Override
    public void e_ClickOnScreen(){
        System.out.println("I'm on edge CLICK ON SCREEN");



    }

    @Override
    public void e_ClickOnImage(){
        System.out.println("I'm on edge CLICK ON IMAGE");



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
    public void e_DiscardNewName(){
        System.out.println("I'm on edge DISCARD NEW NAME");


    }


    @Override
    public void e_ClickOK(){
        System.out.println("I'm on edge CLICK OK");



    }

    @Override
    public void e_ClickOnInfoIcon(){
        System.out.println("I'm on edge CLICK ON INFO ICON");


    }

    @Override
    public void e_GoBackFromSharing(){
        System.out.println("I'm on edge GO BACK FROM SHARING");



    }
    

    @Override
    public void e_GoBackFromEdition(){
        System.out.println("I'm on edge GO BACK FROM EDITION");



    }

    @Override
    public void e_SaveNewName(){
        System.out.println("I'm on edge SAVE NEW NAME");



    }

    
}

    

