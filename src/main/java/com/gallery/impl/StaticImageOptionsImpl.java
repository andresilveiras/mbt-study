package com.gallery.impl;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import com.gallery.model.StaticImageOptions;

@GraphWalker(value = "random(edge_coverage(100))")
public class StaticImageOptionsImpl extends ExecutionContext implements StaticImageOptions {

    /* 
    * ******************************************* 
    *             States / Vertex
    * ******************************************* 
    */  

    @Override
    public void v_ViewImageFullScreen(){
        System.out.println("I'm on vertex VIEW IMAGE FULL SCREEN");
    }

    @Override
    public void v_EditImage(){
        System.out.println("I'm on vertex EDIT IMAGE");
    }

    @Override
    public void v_ShareImage(){
        System.out.println("I'm on vertex SHARE IMAGE");
    }

    @Override
    public void v_RotateImage(){
        System.out.println("I'm on vertex ROTATE IMAGE");
    }

    @Override
    public void v_OpenStaticImageOptions(){
        System.out.println("I'm on vertex OPEN STATIC IMAGE OPTIONS");
    }

    @Override
    public void v_OpenImageProperties(){
        System.out.println("I'm on vertex OPEN IMAGE PROPERTIES");
    }

    /* 
    * ******************************************* 
    *             Events / Edges
    * ******************************************* 
    */



    @Override
    public void e_ClickOnScreen(){
        System.out.println("I'm on edge CLICK ON SCREEN");
    }

    @Override
    public void e_ClickOnImage(){
        System.out.println("I'm on edge CLICK ON IMAGE");
    }

    @Override
    public void e_ClickOnRoteteIcon(){
        System.out.println("I'm on edge CLICK ON ROTATE ICON");
    }

    @Override
    public void e_SelectRotation(){
        System.out.println("I'm on edge SELECT ROTATION");
    }

    @Override
    public void e_ClickOnShareIcon(){
        System.out.println("I'm on edge CLICK ON SHARE ICON");
    }

    @Override
    public void e_SaveChanges(){
        System.out.println("I'm on edge SAVE CHANGES");
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
    public void e_DiscardChanges(){
        System.out.println("I'm on edge DISCARD CHANGES");
    }

    @Override
    public void e_GoBackFromEdition(){
        System.out.println("I'm on edge GO BACK FROM EDITION");
    }

    @Override
    public void e_ClickOnEditIcon(){
        System.out.println("I'm on edge CLICK ON EDIT ICON");

    }
}
