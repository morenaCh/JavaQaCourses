package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private ContactHelper contactHelper;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper; //metoda do ktorej delegujemy 1.link do klasy delegowanej

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper=new SessionHelper(wd);//metoda do ktorej delegujemy 2.inicjalizacja drivera
        contactHelper=new ContactHelper(wd);
        sessionHelper.login("admin","secret");
    }

    public void stop() {
        sessionHelper().logout();
        wd.quit();
    }
    public ContactHelper contactHelper(){return contactHelper;}

    public GroupHelper getGroupHelper() { //metoda do ktorej delegujemy 2.musimy metode do ktorej delegujemy tutaj zwrocic;
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper sessionHelper(){
        return sessionHelper;
    }

}
