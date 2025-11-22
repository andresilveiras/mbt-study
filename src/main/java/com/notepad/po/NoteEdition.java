package com.notepad.po;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NoteEdition extends BasePage {

    // PAGE ELEMENTS

    @AndroidFindBy(xpath="//android.widget.EditText")
    RemoteWebElement textField;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(0)")
    RemoteWebElement backButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(1)")
    RemoteWebElement saveButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(2)")
    RemoteWebElement trashButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.view.View\").instance(2)")
    RemoteWebElement androidDialog;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(0)")
    RemoteWebElement cancelConfirmationButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(1)")
    RemoteWebElement agreeConfirmationButton;


    // Driver instanciation

    public NoteEdition(AndroidDriver d) {
        super(d);
    }

    // PAGE ACTIONS

    // Edition mode Check
    public boolean EditionModeCheck(){
        System.out.println("Checking if user is in edition mode...\n" + textField.isDisplayed());
        return textField.isDisplayed();
    }

    // Enter text --> Stay in the same page

    public void EnterText(String text){
        System.out.println("Entering text: " + text);
        textField.sendKeys(text);
    }

    // Go back --> Go to list notes

    public ListNotes GoBack(){
        System.out.println("Going back from note edition...");
        backButton.click();
        return new ListNotes(d);
    }

    // Discard -- Cancel confirmation --> Stay in the same page

    public void CancelDiscard(){
        System.out.println("Clicking to discard note...");
        trashButton.click();
        // Checking confirmation dialog
        if(androidDialog.isDisplayed()){
            System.out.println("Canceling discard confirmation...");
            cancelConfirmationButton.click();
        }else{
            System.out.println("Action failed. Discard was not confirmed.");
        } 
    }  

    // Discard -- Confirm discard --> Go to list notes

    public ListNotes DiscardNote(){
        System.out.println("Clicking to discard note...");
        trashButton.click();
        // Checking confirmation dialog
        if(androidDialog.isDisplayed()){
            System.out.println("Confirming discard...");
            agreeConfirmationButton.click();
        }else{
            System.out.println("Action failed. Discard was not confirmed.");
        }
        return new ListNotes(d);
    }   
    
     // Discard -- Confirm discard --> Go to list notes (empty)

     public ListNotesEmpty DiscardOnlyNote(){
        System.out.println("Clicking to discard note...");
        trashButton.click();
        // Checking confirmation dialog
        if(androidDialog.isDisplayed()){
            System.out.println("Confirming discard...");
            agreeConfirmationButton.click();
        }else{
            System.out.println("Action failed. Discard was not confirmed.");
        }
        return new ListNotesEmpty(d);
    }  

    // Save --> Go to NOTE DETAILS

    public NoteDetails SaveEditedNote(){
        System.out.println("Clicking to save note...");
        saveButton.click();
        return new NoteDetails(d);
    }
}
