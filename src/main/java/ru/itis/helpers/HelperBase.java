package ru.itis.helpers;

import org.openqa.selenium.WebDriver;
import ru.itis.ApplicationManager;

public class HelperBase {
    protected WebDriver driver;
    protected ApplicationManager applicationManager;

    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }

}
