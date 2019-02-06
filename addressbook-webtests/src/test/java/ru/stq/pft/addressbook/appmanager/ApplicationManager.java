package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import ru.stq.pft.addressbook.tests.BaseTest;
import org.openqa.selenium.remote.BrowserType;


import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public WebDriver wd;
    private String browser;

    public ContactHelper contactHelper;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper; //metoda do ktorej delegujemy 1.link do klasy delegowanej

    public ApplicationManager(String browser) {
        this.browser=browser;
    }

        public void init() {
        if (browser==BrowserType.CHROME){
            wd = new ChromeDriver();
        }else if(browser==BrowserType.FIREFOX){
            wd = new FirefoxDriver();
        }else if(browser==BrowserType.IE) {
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);//metoda do ktorej delegujemy 2.inicjalizacja drivera
        contactHelper = new ContactHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        sessionHelper().logout();
        wd.quit();
    }

    public void switchTo() {
        wd.switchTo().alert().accept();
    }

    public ContactHelper contactHelper() {
        return contactHelper;
    }

    public GroupHelper getGroupHelper() { //metoda do ktorej delegujemy 2.musimy metode do ktorej delegujemy tutaj zwrocic;
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper sessionHelper() {
        return sessionHelper;
    }


}
