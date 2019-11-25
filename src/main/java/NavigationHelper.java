import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {
    void openHomePage() {
        driver.get("http://www.cyberforum.ru/");
    }
    void openProfile() {
        driver.findElement(By.linkText("Профиль")).click();
    }

}
