package ru.itis.tests;

import org.junit.Test;
import ru.itis.ApplicationManager;

public class LogoutTest {

    private ApplicationManager applicationManager = new ApplicationManager();

    @Test
    public void testLogOut() {
//        testSignIn();
        applicationManager.getAuth().logout();
    }

}
