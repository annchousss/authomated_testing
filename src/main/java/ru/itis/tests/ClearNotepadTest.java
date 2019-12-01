package ru.itis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.ApplicationManager;
import ru.itis.model.AccountData;
import ru.itis.model.NotepadData;

public class ClearNotepadTest extends TestBase {

    @Test
    public void clearNotepad() {
        AccountData user = new AccountData("annie.tugb@gmail.com","Annchs20" );
        applicationManager.getNavigation().openHomePage();
        applicationManager.getAuth().login(user.getUsername(), user.getPassword());
        applicationManager.getNavigation().openProfile();
        applicationManager.getNotepad().clearNotepad();
        applicationManager.getNotepad().saveNotepad();

        NotepadData notepad = new NotepadData("Здесь вы можете сохранять собственные заметки и памятки. Вы - единственный, кто может видеть эти записи.");
        NotepadData createdNotepad = applicationManager.getNotepad().getCreatedNotepadNote();
        Assert.assertEquals(notepad.getString(), createdNotepad.getString());

    }

}
