package ru.stq.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stq.pft.addressbook.appmanager.ApplicationManager;

public class BaseTest {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.sessionHelper().logout();
        app.stop();
      }
}
