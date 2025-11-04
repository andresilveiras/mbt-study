package com.gallery.impl;

import java.net.MalformedURLException;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;

import com.gallery.DriverRunner;
import com.gallery.model.MainFlow;
import com.gallery.po.ListFolders;
import com.gallery.po.ListGifs;
import com.gallery.po.ListStaticImages;
import com.gallery.po.ListVideos;
import com.gallery.po.OpenPage;

import io.appium.java_client.android.AndroidDriver;

@GraphWalker(value = "random(edge_coverage(100))", start = "v_Start")
public class MainFlowImpl extends ExecutionContext implements MainFlow {

    AndroidDriver driver; 

    OpenPage openPage;
    ListFolders listFolders;
    ListStaticImages listStaticImages;
    ListGifs listAnimatedImages;
    ListVideos listVideos;

    String currentFolder = "StaticImage";

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
        if(openPage == null) openPage = new OpenPage(driver);
    }

    @Override
    public void e_RejectPermissions(){
        System.out.println("I'm on edge REJECT PERMISSIONS");
        if(openPage == null) openPage = new OpenPage(driver);
        openPage.rejectPermissions();
    }

    @Override
    public void e_EnablePermissions(){
        System.out.println("I'm on edge ENABLE PERMISSIONS");
        if(openPage == null) openPage = new OpenPage(driver);
        openPage.allowPermissions();
    }

    @Override
    public void e_SelectFolder(){
        System.out.println("I'm on edge SELECT FOLDER");
        if(listFolders == null) listFolders = new ListFolders(driver);

        switch (currentFolder) {
            case "StaticImage":
                // choose one of the static images folder randomly
                selectStaticImageFolder();  
            break;
            case "AnimatedImage":
                listFolders.clickOnGifsFolder();
            break;
            case "Video":
                listFolders.clickOnVideosFolder();
            break;
        }
    }

    @Override
    public void e_GoBackFromFolderItems(){
        System.out.println("I'm on edge GO BACK FROM FOLDER ITEMS");

        switch(currentFolder){
            case "StaticImage":
                listStaticImages.goBackFromStaticImages();
                break;
            case "AnimatedImage":
                listAnimatedImages.goBackFromGifImages();
                break;
            case "Video":
                listVideos.goBackFromVideos();
                break;
        }

    }
    
    @Override
    public void e_SelectStaticImage(){
        System.out.println("I'm on edge SELECT STATIC IMAGE");
        if(currentFolder.equals("StaticImage")){
            System.out.println("Current folder: " + currentFolder);
            if(listStaticImages == null) listStaticImages = new ListStaticImages(driver);
            listStaticImages.clickOnFirstItem();
        }else{
            System.out.println("Current folder: " + currentFolder + ".\nGoing back to select the right folder.");
            switch(currentFolder){
                case "AnimatedImage":
                    if(listAnimatedImages == null) listAnimatedImages = new ListGifs(driver);
                    listAnimatedImages.goBackFromGifImages();
                    if(listFolders == null) listFolders = new ListFolders(driver);
                    selectStaticImageFolder();
                    currentFolder = "StaticImage";
                    break;
                case "Video":
                    if(listVideos == null) listVideos = new ListVideos(driver);
                    listVideos.goBackFromVideos();
                    if(listFolders == null) listFolders = new ListFolders(driver);
                    selectStaticImageFolder();
                    currentFolder = "StaticImage";
                    break;
            }
        }
    }

    @Override
    public void e_GoBackFromStaticImage(){
        System.out.println("I'm on edge GO BACK FROM STATIC IMAGE");
        if(listStaticImages == null) listStaticImages = new ListStaticImages(driver);
        listStaticImages.goBackFromStaticImages();
    }

    @Override
    public void e_SelectAnimatedImage(){
        System.out.println("I'm on edge SELECT ANIMATED IMAGE");

        if(currentFolder.equals("AnimatedImage")){
            System.out.println("Current folder: " + currentFolder);
            if(listAnimatedImages == null) listAnimatedImages = new ListGifs(driver);
            listAnimatedImages.clickOnFirstItem();
        }else{
            System.out.println("Current folder: " + currentFolder + ".\nGoing back to select the right folder.");
            switch(currentFolder){
                case "StaticImage":
                    if(listStaticImages == null) listStaticImages = new ListStaticImages(driver);
                    listStaticImages.goBackFromStaticImages();
                    if(listFolders == null) listFolders = new ListFolders(driver);
                    listFolders.clickOnGifsFolder();
                    currentFolder = "AnimatedImage";
                    break;
                case "Video":
                    if(listVideos == null) listVideos = new ListVideos(driver);
                    listVideos.goBackFromVideos();
                    if(listFolders == null) listFolders = new ListFolders(driver);
                    listFolders.clickOnGifsFolder();
                    currentFolder = "AnimatedImage";
                    break;
            }
        }
    }

    @Override
    public void e_GoBackFromAnimatedImage(){
        System.out.println("I'm on edge GO BACK FROM ANIMATED IMAGE");
        if(listAnimatedImages == null) listAnimatedImages = new ListGifs(driver);
        listAnimatedImages.goBackFromGifImages();
    }

    @Override
    public void e_SelectVideo(){
        System.out.println("I'm on edge SELECT VIDEO");

        if(currentFolder.equals("Video")){
            System.out.println("Current folder: " + currentFolder);
            if(listVideos == null) listVideos = new ListVideos(driver);
            listVideos.clickOnFirstItem();
        }else{
            System.out.println("Current folder: " + currentFolder + ".\nGoing back to select the right folder.");
            switch(currentFolder){
                case "StaticImage":
                    if(listStaticImages == null) listStaticImages = new ListStaticImages(driver);
                    listStaticImages.goBackFromStaticImages();
                    if(listFolders == null) listFolders = new ListFolders(driver);
                    listFolders.clickOnVideosFolder();
                    currentFolder = "Video";
                break;
                case "AnimatedImage":
                    if(listAnimatedImages == null) listAnimatedImages = new ListGifs(driver);
                    listAnimatedImages.goBackFromGifImages();
                    if(listFolders == null) listFolders = new ListFolders(driver);
                    listFolders.clickOnVideosFolder();
                    currentFolder = "Video";
                break;
            }
            if(listVideos == null) listVideos = new ListVideos(driver);
            listVideos.clickOnFirstItem();
        }
    }

    @Override
    public void e_GoBackFromVideo(){
        System.out.println("I'm on edge GO BACK FROM VIDEO");
        if(listVideos == null) listVideos = new ListVideos(driver);
        listVideos.goBackFromVideos();
    }


    public void selectStaticImageFolder(){
        if(listFolders == null) listFolders = new ListFolders(driver);
        int randomChoice = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 4);
        switch(randomChoice){
            case 1: 
                listFolders.clickOnJpegFolder();
                break;
            case 2: 
                listFolders.clickOnPngFolder();
                break;
            case 3: 
                listFolders.clickOnWebpFolder();
                break;
        }           
    }

}
