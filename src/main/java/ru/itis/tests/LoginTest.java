package ru.itis.tests;

import org.junit.Test;
import ru.itis.model.AccountData;

public class LoginTest extends TestBase {

    @Test
    public void testSignIn() {
        AccountData user = new AccountData("annie.tugb@gmail.com","Annchs20" );
        applicationManager.getNavigation().openHomePage();
        applicationManager.getAuth().login(user.getUsername(), user.getPassword());
        applicationManager.closeBrowser();
    }

}
