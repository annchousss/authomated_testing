import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NotepadHelper extends HelperBase {
    void saveNotepad() {
        WebElement save = driver.findElement(By.cssSelector("input[value='Сохранить запись']"));
        save.click();
    }

    void addStringToNotepad(String newString) {
        WebElement notepad = driver.findElement(By.name("notepad"));
        notepad.click();
        notepad.sendKeys(newString);
    }

}
