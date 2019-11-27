package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.ApplicationManager;
import ru.itis.model.NotepadData;

public class ClearNotepad {

    private ApplicationManager applicationManager;

    @Test
    public void clearNotepad() {
//        testSignIn();
        applicationManager.getNavigation().openProfile();
        applicationManager.getNotepad().clearNotepad();
        applicationManager.getNotepad().saveNotepad();

        NotepadData notepad = new NotepadData("Здесь вы можете сохранять собственные заметки и памятки. Вы - единственный, кто может видеть эти записи.");
        NotepadData createdNotepad = applicationManager.getNotepad().getCreatedNotepadNote();
        Assert.assertEquals(notepad.getString(), createdNotepad.getString());

    }

}
