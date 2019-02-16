package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver wd) {

        super(wd);
    }

    public void goToContactPage() {
        click(By.linkText("add new"));}

    public void goToGroupPage() {
        if (isElementPresent(By.xpath("//div/div[4]/h1"))
                && wd.findElement(By.xpath("//div/div[4]/h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }


    public void goToHomePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }
}
