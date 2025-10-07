package com.gallery.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class OpenPage extends BasePage {

    // Driver instanciation
    public OpenPage(AndroidDriver d) {
        super(d);
        System.out.println("I'm on Open Page");
        if(d == null){
            System.out.println("Driver is null");
        }else{
            System.out.println("Driver is NOT null");
        }
    }

    // PAGE ELEMENTS

    @AndroidFindBy(id="com.android.permissioncontroller:id/content_container")
    RemoteWebElement permissionDialog;

    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
    RemoteWebElement allowPermissionButton;

    // PAGE ACTIONS

    public AndroidDriver checkPermissionDialog() {
        System.out.println("Checking android dialog...");
        System.out.println("first access dialog: " + permissionDialog.isEnabled());
        if (permissionDialog.isDisplayed()) {
            System.out.println("Closing android dialog.");
            allowPermissionButton.click();
        } else {
            System.out.println("There is no dialog to be closed.");
        }
        return d;
    }
}
