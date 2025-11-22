package com.notepad.po;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreateNote extends BasePage {

    // PAGE ELEMENTS

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Nova Nota\")")
    RemoteWebElement newNoteTitle;

    @AndroidFindBy(xpath="//android.widget.EditText")
    RemoteWebElement textField;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(0)")
    RemoteWebElement backButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(1)")
    RemoteWebElement saveButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(2)")
    RemoteWebElement trashButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(0)")
    RemoteWebElement cancelConfirmationButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(1)")
    RemoteWebElement agreeConfirmationButton;

    // Driver instanciation

    public CreateNote(AndroidDriver d) {
        super(d);
    }

    // PAGE ACTIONS

    // Check Page --> Stay in the same page

    public boolean NewNoteCheck(){
        return newNoteTitle.isDisplayed();
    }

    // Enter text --> Stay in the same page

    public void EnterText(String text){
        System.out.println(" Entering text: " + text);
        textField.sendKeys(text);
    }

     // Go back --> Go to list notes (empty)

     public ListNotesEmpty GoBackToEmpty(){
        System.out.println("Going back from note creation...");
        backButton.click();
        return new ListNotesEmpty(d);
    }

    // Go back --> Go to list notes

    public ListNotes GoBack(){
        System.out.println("Going back from note creation...");
        backButton.click();
        return new ListNotes(d);
    }

    // Discard -- Cancel confirmation --> Stay in the same page

    public void CancelDiscard(){
        System.out.println("Clicking to discard new note...");
        trashButton.click();
        System.out.println("Canceling discard confirmation...");
        cancelConfirmationButton.click();
    }  

     // Discard -- Confirm discard --> Go to list notes (empty)

     public ListNotesEmpty DiscardNewFirstNote(){
        System.out.println("Clicking to discard new note...");
        trashButton.click();
        System.out.println("Confirming discard...");
        agreeConfirmationButton.click();
        return new ListNotesEmpty(d);
    } 

    // Discard -- Confirm discard --> Go to list notes 

    public ListNotes DiscardNewNote(){
        System.out.println("Clicking to discard new note...");
        trashButton.click();
        System.out.println("Confirming discard...");
        agreeConfirmationButton.click();
        return new ListNotes(d);
    }    

    // Save --> Go to NOTE DETAILS

    public NoteDetails SaveNewNote(boolean isFirstNote){
        System.out.println("Clicking to save new note...");
        saveButton.click();
        // Checking confirmation dialog
        System.out.println("Checking if the android dialog popped up...");
        if(isFirstNote){
            System.out.println("Closing android dialog...");
            RemoteWebElement closeAndroidDialog = (RemoteWebElement)d.findElement(By.xpath("//android.widget.Button"));
            closeAndroidDialog.click();
        }else{
            System.out.println("Android dialog not displayed.");
        }
        return new NoteDetails(d);
    }
    
}
