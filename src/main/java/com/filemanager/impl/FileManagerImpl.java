package com.filemanager.impl;

import java.net.MalformedURLException;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;

import com.gallery.DriverRunner;

import io.appium.java_client.android.AndroidDriver;
import models.FileManager;

@GraphWalker(value = "random(edge_coverage(100))", start = "v_Start")
public class FileManagerImpl extends ExecutionContext implements FileManager {

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

    @Override
    public void e_OpenApp(){

    }

    @Override
    public void e_CreateNewFolder(){

    }

    @Override
    public void e_RenameFolder(){

    }

    @Override
    public void v_ListFolders(){

    }

    @Override
    public void v_NewFolder(){

    }

    @Override
    public void e_DeleteFolder(){

    }

    @Override
    public void v_Start(){

    }

    @Override
    public void v_NewFile(){

    }

    @Override
    public void e_CreateNewFile(){

    }

    @Override
    public void e_DeleteFile(){

    }

    @Override
    public void e_RenameFile(){

    }
}
