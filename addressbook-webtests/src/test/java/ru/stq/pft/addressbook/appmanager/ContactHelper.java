package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stq.pft.addressbook.model.GroupDataContact;

public class ContactHelper extends BaseHelper {

    private WebDriver wd;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void goToContactPage() {
        click(By.linkText("add new"));
    }

    public void fillPersonalData(GroupDataContact groupDataContact) {
        type(By.name("firstname"),groupDataContact.getFirstName());
        type(By.name("middlename"),groupDataContact.getMiddelname());
        type(By.name("lastname"), groupDataContact.getLastname());
        type(By.name("address"),groupDataContact.getAddress());
        type(By.name("mobile"),groupDataContact.getMobilePhone());
        type(By.name("email"),groupDataContact.getEmail());
    }
    public void clickSubmitButton() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void returnToNewContact() {
        click(By.linkText("home"));
    }


}
