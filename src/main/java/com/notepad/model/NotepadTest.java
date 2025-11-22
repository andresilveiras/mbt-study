package com.notepad.model;

import java.net.MalformedURLException;

import org.graphwalker.java.annotation.Edge;
import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;

@Model(file = "src/main/resources/NotepadTestModel_v1.json")
public interface NotepadTest {

     /* 
    * ******************************************* 
    *             States / Vertex
    * ******************************************* 
    */

    @Vertex
    public void v_Start() throws MalformedURLException;

    @Vertex
    public void v_ListNotes();

    @Vertex
    public void v_NewNote();

    @Vertex
    public void v_NoteDetails();

    @Vertex
    public void v_NoteEdition();


    /* 
    * ******************************************* 
    *             Events / Edges
    * ******************************************* 
    */

    // New note

    @Edge
    public void e_ViewListNotes();

    @Edge
    public void e_CreateNote();

    @Edge
    public void e_GoBackFromCreation();

    @Edge
    public void e_DiscardNewNote();

    @Edge
    public void e_SaveNewNote();

    // Note Details

    @Edge
    public void e_SelectNote();

    @Edge
    public void e_GoBackFromDetails();

    @Edge
    public void e_DeleteSelectedNote();

    @Edge
    public void e_EditNote();


    // Note Edition

    @Edge
    public void e_GoBackFromEdition();

    @Edge
    public void e_DeleteEditedNote();

    @Edge
    public void e_SaveEditedNote();

}
