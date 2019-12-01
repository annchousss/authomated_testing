package ru.itis;

import ru.itis.helpers.LoginHelper;
import ru.itis.helpers.NavigationHelper;
import ru.itis.helpers.NotepadHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {

    private WebDriver driver;
    private String baseURL;
    private LoginHelper auth;
    private NavigationHelper navigation;
    private NotepadHelper notepad;


    public ApplicationManager() {
        this.driver = new ChromeDriver();
        this.baseURL = "http://www.cyberforum.ru/";
        this.auth = new LoginHelper(this);
        this.navigation = new NavigationHelper(this);
        this.notepad = new NotepadHelper(this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    private static ThreadLocal<ApplicationManager> app;

    public static ApplicationManager getInstance(){
        synchronized (ApplicationManager.class){
            if (app == null){
                app = new ThreadLocal<ApplicationManager>();
                ApplicationManager newInstance = new ApplicationManager();
                newInstance.getNavigation().openHomePage();
                app.set(newInstance);
            }
            return app.get();
        }
    }

    public String getBaseURL() {
        return baseURL;
    }

    public LoginHelper getAuth() {
        return auth;
    }

    public NavigationHelper getNavigation() {
        return navigation;
    }

    public NotepadHelper getNotepad() {
        return notepad;
    }

    public void closeBrowser(){
        driver.quit();
    }

}
