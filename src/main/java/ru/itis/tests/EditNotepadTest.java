package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.ApplicationManager;
import ru.itis.model.NotepadData;

public class EditNotepadTest {

    private ApplicationManager applicationManager = new ApplicationManager();

    @Test
    public void addNewNote() {
//        testSignIn();
        NotepadData notepadData = new NotepadData("string1");
        applicationManager.getNavigation().openProfile();
        applicationManager.getNotepad().addStringToNotepad(notepadData.getString());
        applicationManager.getNotepad().saveNotepad();
        NotepadData notepad = new NotepadData(notepadData.getString());
        NotepadData createdNotepad = applicationManager.getNotepad().getCreatedNotepadNote();
        Assert.assertEquals(notepad.getString(), createdNotepad.getString());
    }


}
