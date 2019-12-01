package ru.itis.tests;

import org.junit.Test;
import ru.itis.ApplicationManager;
import ru.itis.model.AccountData;

public class LogoutTest extends TestBase {

    @Test
    public void testLogOut() {
        AccountData user = new AccountData("annie.tugb@gmail.com","Annchs20" );
        applicationManager.getNavigation().openHomePage();
        applicationManager.getAuth().login(user.getUsername(), user.getPassword());
        applicationManager.getAuth().logout();
    }

}
