package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    ChromeDriver wd;

    private SessionHelper sessionHelper; //metoda do ktorej delegujemy 1.link do klasy delegowanej
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper=new SessionHelper(wd);//metoda do ktorej delegujemy 2.inicjalizacja drivera
        wd.get("http://localhost/addressbook/group.php");
        sessionHelper.login("admin","secret");
    }

    public void stop() {
        wd.quit();
    }

    public void returnToNewContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void clickSubmitButton() {
       wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void initAddNewContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

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
