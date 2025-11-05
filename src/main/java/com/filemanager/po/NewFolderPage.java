package com.filemanager.po;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class NewFolderPage extends BasePage {

    // Driver instanciation
    public NewFolderPage(AndroidDriver driver) {
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

    @AndroidFindBy(id="org.fossify.filemanager:id/items_fab")
    RemoteWebElement button_CreateNew;

    @AndroidFindBy(id="org.fossify.filemanager:id/item_title")
    RemoteWebElement textField_ItemTitle;

    @AndroidFindBy(id="org.fossify.filemanager:id/dialog_radio_directory")
    RemoteWebElement radioButton_Directory;

    @AndroidFindBy(id="org.fossify.filemanager:id/dialog_radio_file")
    RemoteWebElement radioButton_File;

    @AndroidFindBy(id="android:id/button1")
    RemoteWebElement button_Confirm;

    @AndroidFindBy(id="org.fossify.filemanager:id/cab_rename")
    RemoteWebElement button_Rename;

    @AndroidFindBy(id="org.fossify.filemanager:id/cab_delete")
    RemoteWebElement button_Delete;

    @AndroidFindBy(id="org.fossify.filemanager:id/rename_item_name")
    RemoteWebElement textField_Rename;

    // PAGE ACTIONS


    public NewFilePage createNewFile(String fileName){
        System.out.println("Creating file named: " + fileName);
        button_CreateNew.click();
        textField_ItemTitle.sendKeys(fileName);
        radioButton_File.click();
        button_Confirm.click();
        return new NewFilePage(driver);
    }

    public void selectFolder(String folderName){
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 
        RemoteWebElement folder = (RemoteWebElement)driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"org.fossify.filemanager:id/item_name\" and @text=\"" + folderName +"\"]"));
        actions.clickAndHold(folder).perform();
    }

    public OpenPage renameFolder(String folderName, String newFolderName){
        selectFolder(folderName);
        button_Rename.click();
        textField_Rename.clear();
        textField_Rename.sendKeys(newFolderName);
        button_Confirm.click();
        return new OpenPage(driver);
    }

    public OpenPage deleteFolder(String folderName){
        selectFolder(folderName);
        button_Delete.click();
        button_Confirm.click();
        return new OpenPage(driver);
    }

}
