import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Tests extends TestBase {

//    WebDriver driver = new ChromeDriver();

    private AccountData user = new AccountData("annie.tugb@gmail.com", "Annchs20");
    private NotepadData notepadData = new NotepadData("string1");

    @BeforeClass
    public static void site_test_1() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    @Test
    public void testSignIn() {
        openHomePage();
        login(user.getUsername(), user.getPassword());
    }

    @Test
    public void addNewNote() {
        testSignIn();
        openProfile();
        addStringToNotepad(notepadData.getString());
        saveNotepad();
    }

    @Test
    public void testLogOut() {
        testSignIn();
        logout();
    }

}
