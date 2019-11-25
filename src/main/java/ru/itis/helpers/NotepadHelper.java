package ru.itis.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.itis.ApplicationManager;

public class NotepadHelper extends HelperBase {
    public NotepadHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void saveNotepad() {
        WebElement save = driver.findElement(By.cssSelector("input[value='Сохранить запись']"));
        save.click();
    }

    public void addStringToNotepad(String newString) {
        WebElement notepad = driver.findElement(By.name("notepad"));
        notepad.click();
        notepad.sendKeys(newString);
    }

}
