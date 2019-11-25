package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.ApplicationManager;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void openHomePage() {
        driver.get(applicationManager.getBaseURL());
    }
    public void openProfile() {
        driver.findElement(By.linkText("Профиль")).click();
    }

}
