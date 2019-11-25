import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginHelper extends HelperBase {
    void login(String userName, String pass) {
        driver.findElement(By.linkText("Войти")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement username = driver.findElement(By.name("vb_login_username"));
        WebElement password = driver.findElement(By.name("vb_login_password"));
        username.sendKeys(userName);
        password.sendKeys(pass);
        WebElement logIn = driver.findElement(By.cssSelector("input[value='Вход']"));
        logIn.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    void logout() {
        driver.findElement(By.linkText("Выход")).click();
        driver.switchTo().alert().accept();
    }
}
