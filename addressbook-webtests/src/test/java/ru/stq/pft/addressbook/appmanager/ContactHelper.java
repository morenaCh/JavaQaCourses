package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stq.pft.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper {

    private WebDriver wd;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }



    public void fillPersonalData(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddelname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("email"), contactData.getEmail());
    }

    public void clickSubmitButton() {

        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void returnToNewContact() {

        click(By.linkText("home"));
    }


    public void initEditContact() {
        click(By.xpath("//td[8]/a/img"));
    }

    public void clickUpdateButton() {
        click(By.name("update"));
    }

    public void initDeleteContact() {
        click(By.name("selected[]"));
    }

    public void submitDelete() {
        click(By.cssSelector("input[value='Delete']"));
    }
}
