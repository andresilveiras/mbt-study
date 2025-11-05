package com.filemanager.impl;

import java.net.MalformedURLException;

import org.apache.commons.lang3.RandomStringUtils;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;

import com.filemanager.po.NewFilePage;
import com.filemanager.po.NewFolderPage;
import com.filemanager.po.OpenPage;

import com.filemanager.model.FileManager;
import com.filemanager.DriverRunner;

import io.appium.java_client.android.AndroidDriver;

@GraphWalker(value = "random(edge_coverage(100))", start = "v_Start")
public class FileManagerImpl extends ExecutionContext implements FileManager {

    AndroidDriver driver;

    OpenPage openPage;
    NewFolderPage newFolder;
    NewFilePage newFile;

    int textSize = 15;
    String folderName;
    String fileName;
    String newName;


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
        System.out.println("I'm on edge OPEN APP");
        if(openPage == null) openPage = new OpenPage(driver);
    }

    @Override
    public void e_CreateNewFolder(){
        System.out.println("I'm on edge CREATE NEW FOLDER");
        if(openPage == null) openPage = new OpenPage(driver);
        folderName = generateRandomText(textSize);
        openPage.createNewDirectory(folderName);

    }

    @Override
    public void e_RenameFolder(){
        System.out.println("I'm on edge RENAME FOLDER");
        newName = generateRandomText(textSize);
        if(newFolder == null) newFolder = new NewFolderPage(driver);
        newFolder.renameFolder(folderName, newName);
        folderName = newName;
    }

    @Override
    public void v_ListFolders(){
        System.out.println("I'm on vertex LIST FOLDERS");
    }

    @Override
    public void v_NewFolder(){
        System.out.println("I'm on vertex NEW FOLDER");
    }

    @Override
    public void e_DeleteFolder(){
        System.out.println("I'm on edge DELETE FOLDER");
        if(newFolder == null) newFolder = new NewFolderPage(driver);
        newFolder.deleteFolder(folderName);

    }

    @Override
    public void v_Start(){
        System.out.println("I'm on vertex START");
    }

    @Override
    public void v_NewFile(){
        System.out.println("I'm on vertex NEW FILE");
       
    }

    @Override
    public void e_CreateNewFile(){
        System.out.println("I'm on edge CREATE NEW FILE");
        if(newFolder == null) newFolder = new NewFolderPage(driver);
        fileName = generateRandomText(textSize);
        newFolder.createNewFile(fileName);

    }

    @Override
    public void e_DeleteFile(){
        System.out.println("I'm on edge DELETE FILE");
        if(newFile == null) newFile = new NewFilePage(driver);
        newFile.deleteFile(fileName);

    }

    @Override
    public void e_RenameFile(){
        System.out.println("I'm on edge RENAME FILE");
        if(newFile == null) newFile = new NewFilePage(driver);
        newName = generateRandomText(textSize);
        newFile.renameFile(fileName, newName);
        fileName = newName;

    }

    public String generateRandomText(int textSize){
        System.out.println("Generating random text of length " + textSize);
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedText = "_1" + RandomStringUtils.random(textSize, useLetters, useNumbers);
        System.out.println("Generated text: " + generatedText);
        return generatedText;
    }
}
