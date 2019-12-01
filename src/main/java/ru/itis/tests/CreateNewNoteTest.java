package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.ApplicationManager;
import ru.itis.model.AccountData;
import ru.itis.model.NotepadData;

public class CreateNewNoteTest extends TestBase {

    @Test
    public void createNewNote() {
        AccountData user = new AccountData("annie.tugb@gmail.com","Annchs20" );
        applicationManager.getNavigation().openHomePage();
        applicationManager.getAuth().login(user.getUsername(), user.getPassword());
        NotepadData notepad = new NotepadData("new note");
        applicationManager.getNavigation().openProfile();
        applicationManager.getNotepad().clearNotepad();
        applicationManager.getNotepad().addStringToNotepad(notepad.getString());
        applicationManager.getNotepad().saveNotepad();

        NotepadData createdNotepad = applicationManager.getNotepad().getCreatedNotepadNote();
        Assert.assertEquals(notepad.getString(), createdNotepad.getString());
    }

}
