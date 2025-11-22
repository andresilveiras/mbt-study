package com.notepad.po;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NoteDetails extends BasePage {

    // PAGE ELEMENTS

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(0)")
    RemoteWebElement backButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(1)")
    RemoteWebElement editButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(2)")
    RemoteWebElement trashButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.view.View\").instance(2)")
    RemoteWebElement androidDialog;

    @AndroidFindBy(uiAutomator="new UiSelector().text(\"Apagar nota\")")
    RemoteWebElement discardNoteText;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(0)")
    RemoteWebElement cancelConfirmationButton;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.Button\").instance(1)")
    RemoteWebElement agreeConfirmationButton;

    // Driver instanciation

    public NoteDetails(AndroidDriver d) {
        super(d);
    }

    // PAGE ACTIONS

    // Check Note Details
    public void CheckNoteText(){
        System.out.println("Checking note text...");
        RemoteWebElement noteText = (RemoteWebElement)d.findElement(By.xpath("(//android.widget.TextView)[1]"));
        System.out.println("Note text displayed: " + noteText.getText());
    }

    // Go Back --> Go to list notes

    public ListNotes GoBack(){
        System.out.println("Going back from note details...");
        backButton.click();
        return new ListNotes(d);
    }

    // Edit --> Go to Note Edition

    public NoteEdition EditNote(){
        System.out.println("Clicking to edit note...");
        editButton.click();
        return new NoteEdition(d);
    }

    // Discard -- Cancel confirmation --> Stay in the same page

    public void CancelDiscard(){
        System.out.println("Clicking to discard new note...");
        trashButton.click();
        // Checking confirmation dialog
        if(discardNoteText.isDisplayed()){
            System.out.println("Canceling discard confirmation...");
            cancelConfirmationButton.click();
        }else{
            System.out.println("Action failed. Discard was not confirmed.");
        } 
    }  

    // Discard -- Confirm discard --> Go to list notes

    public ListNotes DiscardNote(){
        System.out.println("Clicking to discard new note...");
        trashButton.click();
        // Checking confirmation dialog
        if(discardNoteText.isDisplayed()){
            System.out.println("Confirming discard...");
            agreeConfirmationButton.click();
        }else{
            System.out.println("Action failed. Discard was not confirmed.");
        } 
        return new ListNotes(d);
    }    

    // Discard -- Confirm discard --> Go to list notes

    public ListNotesEmpty DiscardOnlyNote(){
        System.out.println("Clicking to discard new note...");
        trashButton.click();
        // Checking confirmation dialog
        if(discardNoteText.isDisplayed() || androidDialog.isDisplayed()){
            System.out.println("Confirming discard...");
            agreeConfirmationButton.click();
        }else{
            System.out.println("Action failed. Discard was not confirmed.");
        } 
        return new ListNotesEmpty(d);
    }   

}