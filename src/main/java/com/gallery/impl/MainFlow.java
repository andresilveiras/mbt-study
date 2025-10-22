package com.gallery.impl;

import java.net.MalformedURLException;

import org.graphwalker.java.annotation.BeforeExecution;

import com.gallery.DriverRunner;
import com.gallery.model.MainFlowInterface;

import io.appium.java_client.android.AndroidDriver;

public class MainFlow implements MainFlowInterface {

    AndroidDriver driver; 


    @BeforeExecution
    public void initDriver(){
        try {
            driver = DriverRunner.createDriver();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        } 
    }    

    /* 
    * ******************************************* 
    *             States / Vertex
    * ******************************************* 
    */

    @Override
    public void v_Start(){
        System.out.println("I'm on vertex START");

    }

    @Override
    public void v_CheckPermissions(){
        System.out.println("I'm on vertex CHECK PERMISSIONS");

    }

    @Override
    public void v_ListFolders(){
        System.out.println("I'm on vertex LIST FOLDERS");

    }

    @Override
    public void v_ListFolderItems(){
        System.out.println("I'm on vertex LIST FOLDER ITEMS");

    }

    @Override
    public void v_OpenAnimatedImage(){
        System.out.println("I'm on vertex OPEN ANIMATED IMAGE");

    
    }

    @Override
    public void v_OpenStaticImage(){
        System.out.println("I'm on vertex OPEN STATIC IMAGE");

    }

    @Override
    public void v_OpenVideo(){
        System.out.println("I'm on vertex OPEN VIDEO");

    }

    /* 
    * ******************************************* 
    *             Events / Edges
    * ******************************************* 
    */

    @Override
    public void e_OpenApp(){
        System.out.println("I'm on edge OPEN APP");

    }

    @Override
    public void e_RejectPermissions(){
        System.out.println("I'm on edge REJECT PERMISSIONS");

    }

     @Override
    public void e_EnablePermissions(){
        System.out.println("I'm on edge ENABLE PERMISSIONS");

    }

    @Override
    public void e_SelectFolder(){
        System.out.println("I'm on edge SELECT FOLDER");

    }

    @Override
    public void e_GoBackFromFolderItems(){
        System.out.println("I'm on edge GO BACK FROM FOLDER ITEMS");

    }
    
    @Override
    public void e_SelectStaticImage(){
        System.out.println("I'm on edge SELECT STATIC IMAGE");

    }

    @Override
    public void e_GoBackFromStaticImage(){
        System.out.println("I'm on edge GO BACK FROM STATIC IMAGE");

    }

    @Override
    public void e_SelectAnimatedImage(){
        System.out.println("I'm on edge SELECT ANIMATED IMAGE");

    }

    @Override
    public void e_GoBackFromAnimatedImage(){
        System.out.println("I'm on edge GO BACK FROM ANIMATED IMAGE");

    
    }

    @Override
    public void e_SelectVideo(){
        System.out.println("I'm on edge SELECT VIDEO");

    }

    @Override
    public void e_GoBackFromVideo(){
        System.out.println("I'm on edge GO BACK FROM VIDEO");

    }

}
