package com.filemanager.po;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class NewFilePage extends BasePage {

    // Driver instanciation
    public NewFilePage(AndroidDriver driver) {
        super(driver);
        System.out.println("I'm on New Folder Page");
        if(driver == null){
            System.out.println("Driver is null");
        }else{
            System.out.println("Driver is NOT null");
        }
        
    }

    Actions actions = new Actions(driver);

    // PAGE ELEMENTS

    @AndroidFindBy(id="android:id/button1")
    RemoteWebElement button_Confirm;
    
    @AndroidFindBy(id="org.fossify.filemanager:id/top_toolbar_search")
    RemoteWebElement textField_Search;

    @AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"org.fossify.filemanager:id/item_frame\").instance(0)")
    RemoteWebElement item_FirstItem;

    @AndroidFindBy(id="org.fossify.filemanager:id/cab_rename")
    RemoteWebElement button_Rename;

    @AndroidFindBy(id="org.fossify.filemanager:id/rename_item_name")
    RemoteWebElement textField_Rename;

    @AndroidFindBy(id="org.fossify.filemanager:id/cab_delete")
    RemoteWebElement button_Delete;

    // PAGE ACTIONS

    public void selectFile(String fileName){
        //textField_Search.sendKeys(fileName);
        //wait(2000);
        actions.clickAndHold(item_FirstItem).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        actions.release(item_FirstItem).perform();
    }

    public void renameFile(String fileName, String newFileName){
        selectFile(fileName);
        System.out.println("Renaming file: " + fileName + " to: " + newFileName);
        button_Rename.click();
        textField_Rename.clear();
        textField_Rename.sendKeys(newFileName);
        button_Confirm.click();
    }

    public NewFolderPage deleteFile(String fileName){
        selectFile(fileName);
        System.out.println("Deleting file: " + fileName);
        button_Delete.click();
        button_Confirm.click();
        return new NewFolderPage(driver);
    }
}
