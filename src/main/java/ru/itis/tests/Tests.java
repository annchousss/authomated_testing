package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.model.AccountData;
import ru.itis.model.NotepadData;

public class Tests extends TestBase {

    @Test
    public void testSignIn() {
        AccountData user = new AccountData("annie.tugb@gmail.com","Annchs20" );
        applicationManager.getNavigation().openHomePage();
        applicationManager.getAuth().login(user.getUsername(), user.getPassword());

    }

    @Test
    public void createNewNote() {
        testSignIn();
        NotepadData notepad = new NotepadData("new note");
        applicationManager.getNavigation().openProfile();
        applicationManager.getNotepad().clearNotepad();
        applicationManager.getNotepad().addStringToNotepad(notepad.getString());
        applicationManager.getNotepad().saveNotepad();

        NotepadData createdNotepad = applicationManager.getNotepad().getCreatedNotepadNote();
        Assert.assertEquals(notepad.getString(), createdNotepad.getString());
        applicationManager.getAuth().logout();
    }

    @Test
    public void addNewNote() {
        testSignIn();
        NotepadData notepadData = new NotepadData("string1");
        applicationManager.getNavigation().openProfile();
        applicationManager.getNotepad().addStringToNotepad(notepadData.getString());
        applicationManager.getNotepad().saveNotepad();
        NotepadData createdNotepad = applicationManager.getNotepad().getCreatedNotepadNote();
        Assert.assertEquals(notepadData.getString(), createdNotepad.getString());
        applicationManager.getAuth().logout();

    }

    @Test
    public void clearNotepad() {
        testSignIn();
        applicationManager.getNavigation().openProfile();
        applicationManager.getNotepad().clearNotepad();
        applicationManager.getNotepad().saveNotepad();

        NotepadData notepad = new NotepadData("Здесь вы можете сохранять собственные заметки и памятки. Вы - единственный, кто может видеть эти записи.");
        NotepadData createdNotepad = applicationManager.getNotepad().getCreatedNotepadNote();
        Assert.assertEquals(notepad.getString(), createdNotepad.getString());
        applicationManager.getAuth().logout();

    }


    @Test
    public void testLogOut() {
        testSignIn();
        applicationManager.getAuth().logout();
    }

}
