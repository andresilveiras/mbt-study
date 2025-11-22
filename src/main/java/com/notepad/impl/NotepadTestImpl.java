package com.notepad.impl;

import java.net.MalformedURLException;

import org.apache.commons.lang3.RandomStringUtils;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;

import com.notepad.DriverRunner;
import com.notepad.model.NotepadTest;
import com.notepad.po.CreateNote;
import com.notepad.po.ListNotes;
import com.notepad.po.ListNotesEmpty;
import com.notepad.po.NoteDetails;
import com.notepad.po.NoteEdition;
import com.notepad.po.OpenPage;

import io.appium.java_client.android.AndroidDriver;

@GraphWalker(value = "random(edge_coverage(100))")
public class NotepadTestImpl extends ExecutionContext implements NotepadTest {

    AndroidDriver driver; 

    int numberOfNotes = 0;
    int textLength = 50;
    String text;
    boolean isFirstNote = true;

    OpenPage welcomePage;
    CreateNote newNotePage;
    ListNotesEmpty emptyListPage;
    ListNotes notesListPage;
    NoteDetails noteDetailsPage;
    NoteEdition noteEditionPage;

    @BeforeExecution
    public void initDriver(){
        try {
            driver = DriverRunner.createDriver();

        } catch (MalformedURLException exc) {
            System.out.println(exc.getCause());
            System.out.println(exc.getMessage());
        } 
    }

    /* 
    * ******************************************* 
    *             States / Vertex
    * ******************************************* 
    */

    @Override
    public void v_Start() {

        System.out.println("I'm on vertex START");

    }

    @Override
    public void v_NewNote() {

        System.out.println("I'm on vertex NEW NOTE");
        if(newNotePage == null){
            newNotePage = new CreateNote(driver);
        }
        newNotePage.NewNoteCheck();
        
    }

    @Override
    public void v_ListNotes() {

        System.out.println("I'm on vertex LIST NOTES");

        System.out.println("The actual number of notes is: " + numberOfNotes);
        if(numberOfNotes == 0){
            if(emptyListPage == null){
                emptyListPage = new ListNotesEmpty(driver);
            }
            emptyListPage.IsListNotesEmpty();
        }else{
            if(notesListPage == null){
                notesListPage = new ListNotes(driver);
            }
            notesListPage.CheckMainPage();
        }

    }

    @Override
    public void v_NoteDetails() {

        System.out.println("I'm on vertex NOTE DETAILS");

        if(noteDetailsPage == null){
            noteDetailsPage = new NoteDetails(driver);
        }
        if(numberOfNotes > 0){
            noteDetailsPage.CheckNoteText();
        }else{
            System.out.println("There is no note to select.");
        }        

    }

    @Override
    public void v_NoteEdition() {

        System.out.println("I'm on vertex NOTE EDITION");

        if(noteEditionPage == null){
            noteEditionPage = new NoteEdition(driver);
        }
        if(numberOfNotes > 0){
            noteEditionPage.EditionModeCheck();
        }else{
            System.out.println("There is no note to select.");
        } 
    }


    /* 
    * ******************************************* 
    *             Events / Edges
    * ******************************************* 
     */
    // New note
    @Override
    public void e_ViewListNotes() {

        System.out.println("I'm on edge VIEW LIST NOTES");

        welcomePage = new OpenPage(driver);
        welcomePage.checkFirstDialog();

    }

    @Override
    public void e_CreateNote() {

        System.out.println("I'm on edge CREATE NOTE");

        if(numberOfNotes == 0){
            emptyListPage.CreateNewNote();
        }else{
            notesListPage.CreateNewNote();
        }

    }

    @Override
    public void e_GoBackFromCreation() {

        System.out.println("I'm on edge GO BACK FROM CREATION");

        if(numberOfNotes == 0){
            newNotePage.GoBackToEmpty();
        }else{
            newNotePage.GoBack();
        }

    }

    @Override
    public void e_DiscardNewNote() {

        System.out.println("I'm on edge DISCARD NEW NOTE");

        if(numberOfNotes == 0){
            newNotePage.CancelDiscard();
            newNotePage.DiscardNewFirstNote();
        }else{
            newNotePage.CancelDiscard();
            newNotePage.DiscardNewNote();
        }

    }

    @Override
    public void e_SaveNewNote() {

        System.out.println("I'm on edge SAVE NEW NOTE");
        
        text = generateRandomText(textLength);
        newNotePage.EnterText(text);
        newNotePage.SaveNewNote(isFirstNote);
        numberOfNotes++;
        isFirstNote = false;
        System.out.println("The number of notes was increased to: " + numberOfNotes);

    }

    // Note Details
    @Override
    public void e_SelectNote() {

        System.out.println("I'm on edge SELECT NOTE");

        if(numberOfNotes == 0){
            System.out.println("There is no note to select.");
        }else{
            notesListPage.SelectFirstNote();
        }

    }

    @Override
    public void e_GoBackFromDetails() {

        System.out.println("I'm on edge GO BACK FROM DETAILS");

        if(numberOfNotes == 0){
            System.out.println("There is no note to select.");
        }else{
            noteDetailsPage.GoBack();
        }

    }

    @Override
    public void e_DeleteSelectedNote() {

        System.out.println("I'm on edge DELETE SELECTED NOTE");

        if(numberOfNotes == 0){
            System.out.println("There is no note to delete.");
        }else{
            noteDetailsPage.CancelDiscard();
            if(numberOfNotes == 1){
                noteDetailsPage.DiscardOnlyNote();
                numberOfNotes--;
            }else{
                noteDetailsPage.DiscardNote();
                numberOfNotes--;
            }   
            System.out.println("The number of notes was decreased to: " + numberOfNotes); 
        }        

    }

    @Override
    public void e_EditNote() {

        System.out.println("I'm on edge EDIT NOTE");

        if(numberOfNotes == 0){
            System.out.println("There is no note to edit.");
        }else{
            noteDetailsPage.EditNote();
        }

    }

    // Note Edition
    @Override
    public void e_GoBackFromEdition() {

        System.out.println("I'm on edge GO BACK FROM EDITION");

        if(numberOfNotes == 0){
            System.out.println("There is no note to edit.");
        }else{
            noteEditionPage.GoBack();
        }

    }

    @Override
    public void e_DeleteEditedNote() {

        System.out.println("I'm on edge DELETE EDITED NOTE");

        if(numberOfNotes == 0){
            System.out.println("There is no note to edit.");
        }else{
            noteEditionPage.CancelDiscard();
            if(numberOfNotes == 1){
                noteEditionPage.DiscardOnlyNote();
                numberOfNotes--;
            }else{
                noteEditionPage.DiscardNote();
                numberOfNotes--;
            }   
            System.out.println("The number of notes was decreased to: " + numberOfNotes); 
        } 

    }

    @Override
    public void e_SaveEditedNote() {

        System.out.println("I'm on edge SAVE EDITED NOTE");

        if(numberOfNotes == 0){
            System.out.println("There is no note to edit.");
        }else{
            text = generateRandomText(textLength);
            noteEditionPage.EnterText(text);
            noteEditionPage.SaveEditedNote();
        }  

    }

    public String generateRandomText(int textSize){
        System.out.println("Generating random text of length " + textSize);
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedText = RandomStringUtils.random(textSize, useLetters, useNumbers);
        System.out.println("Generated text: " + generatedText);
        return generatedText;
    }

}
