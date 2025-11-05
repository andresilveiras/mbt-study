package com.gallery.po;

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

    @AndroidFindBy(id="com.android.permissioncontroller:id/content_container")
    RemoteWebElement androidPermissionDialog;

    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
    RemoteWebElement allowPermissionButton;


    // PAGE ACTIONS

    public ListFolders allowPermissions() {
        System.out.println("Checking android dialog...");
        System.out.println("First access dialog: " + androidPermissionDialog.isEnabled());
        if (androidPermissionDialog.isDisplayed()) {
            System.out.println("Allowing permissions.");
            allowPermissionButton.click();
        } else {
            System.out.println("First access dialog is not displayed.");
            // consider permissions are already allowed
        }
        return new ListFolders(driver);
    }

    public void rejectPermissions(){
        System.out.println("Checking android dialog...");
        System.out.println("First access dialog: " + androidPermissionDialog.isEnabled());
        if (androidPermissionDialog.isDisplayed()) {
            // do nothing, just stand on this page. otherwise the dialog don't show up again.
            System.out.println("Don't allow permissions.");
        } else {
            System.out.println("First access dialog is not displayed.");
            // consider permissions are already allowed
        }
    }
}
