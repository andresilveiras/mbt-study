package com.gallery.po;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class BasePage {
    protected AndroidDriver d;
    
    public BasePage(AndroidDriver d) {
        this.d = d;
        PageFactory.initElements(new AppiumFieldDecorator(d, Duration.ofSeconds(3600)), this);
    }
}
