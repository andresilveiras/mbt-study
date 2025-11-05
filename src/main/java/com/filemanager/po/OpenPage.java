package com.filemanager.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class OpenPage extends BasePage {

    // Driver instanciation
    public OpenPage(AndroidDriver driver) {
        super(driver);
        System.out.println("I'm on Open Page");
        if(driver == null){
            System.out.println("Driver is null");
        }else{
            System.out.println("Driver is NOT null");
        }
    }

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

    @AndroidFindBy(id="org.fossify.filemanager:id/top_toolbar_search")
    RemoteWebElement textField_Search;

    @AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"org.fossify.filemanager:id/item_frame\").instance(0)")
    RemoteWebElement item_FirstItem;


    // PAGE ACTIONS


    public NewFolderPage createNewDirectory(String directoryName){
        System.out.println("Creating directory named: " + directoryName);
        button_CreateNew.click();
        textField_ItemTitle.sendKeys(directoryName);
        radioButton_Directory.click();
        button_Confirm.click();
        System.out.println("Clicking on created folder: " + directoryName);
        textField_Search.sendKeys(directoryName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        item_FirstItem.click();
        return new NewFolderPage(driver);
    }

}
