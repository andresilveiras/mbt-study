package com.notepad.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ListNotesEmpty extends BasePage {

    // PAGE ELEMENTS:

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(3)")
    RemoteWebElement addButton;

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Nenhuma nota encontrada\")")
    RemoteWebElement emptyListNotesLabel;

    // Driver instanciation

    public ListNotesEmpty(AndroidDriver d) {
        super(d);
    }

    // PAGE ACTIONS:

    // Check if the list notes is empty --> Stay in the same page

    public boolean IsListNotesEmpty(){
        System.out.println("List is empty: " + emptyListNotesLabel.isDisplayed());
        return emptyListNotesLabel.isDisplayed();
    }

    // Create new note --> Go to create note

    public CreateNote CreateNewNote(){
        System.out.println("Clicking on New Note button");
        addButton.click();
        return new CreateNote(d);
    }

}
