package com.notepad.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ListNotes extends BasePage {

    // PAGE ELEMENTS:

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Notepad\")")
    RemoteWebElement mainScreenTitle;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(3)")
    RemoteWebElement addButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.view.View\").instance(3)")
    RemoteWebElement firstNoteOption;

    // Driver instanciation

    public ListNotes(AndroidDriver d) {
        super(d);
    }

    // PAGE ACTIONS:

    // Check that is in main page --> Stay in the same page
    public boolean CheckMainPage(){
        System.out.println("Main Page check...");
        return mainScreenTitle.isDisplayed();
    }

    // Create new note --> Go to create note

    public CreateNote CreateNewNote(){
        System.out.println("Clicking on New Note button");
        addButton.click();
        return new CreateNote(d);
    }

    // Select Note --> Go to NOTE DETAILS

    public NoteDetails SelectFirstNote(){
        System.out.println("Selecting the first note...");
        firstNoteOption.click();
        return new NoteDetails(d);
    }
}
