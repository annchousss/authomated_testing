package ru.itis.tests;

import ru.itis.ApplicationManager;
import ru.itis.model.AccountData;
import ru.itis.model.NotepadData;
import org.junit.BeforeClass;
import org.junit.Test;


public class Tests extends TestBase {

    private ApplicationManager applicationManager = new ApplicationManager();
    private AccountData user = new AccountData("annie.tugb@gmail.com", "Annchs20");
    private NotepadData notepadData = new NotepadData("string1");

    @BeforeClass
    public static void site_test_1() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    @Test
    public void testSignIn() {
        applicationManager.getNavigation().openHomePage();
        applicationManager.getAuth().login(user.getUsername(), user.getPassword());
    }

    @Test
    public void addNewNote() {
        testSignIn();
        applicationManager.getNavigation().openProfile();
        applicationManager.getNotepad().addStringToNotepad(notepadData.getString());
        applicationManager.getNotepad().saveNotepad();
    }

    @Test
    public void testLogOut() {
        testSignIn();
        applicationManager.getAuth().logout();
    }

}
