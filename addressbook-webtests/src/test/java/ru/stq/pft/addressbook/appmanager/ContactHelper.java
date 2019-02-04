package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stq.pft.addressbook.model.GroupDataContact;
import ru.stq.pft.addressbook.model.GroupDataContactModification;

public class ContactHelper extends BaseHelper {

    private WebDriver wd;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }



    public void fillPersonalData(GroupDataContact groupDataContact) {
        type(By.name("firstname"),groupDataContact.getFirstName());
        type(By.name("middlename"),groupDataContact.getMiddelname());
        type(By.name("lastname"), groupDataContact.getLastname());
        type(By.name("address"),groupDataContact.getAddress());
        type(By.name("mobile"),groupDataContact.getMobilePhone());
        type(By.name("email"),groupDataContact.getEmail());
    }

    public void fillPersonalModificationData(GroupDataContactModification groupDataContactModification){
        type(By.name("address"),groupDataContactModification.getAddress());
        type(By.name("mobile"),groupDataContactModification.getMobilePhone());
        type(By.name("email"),groupDataContactModification.getEmail());
    }
    public void clickSubmitButton() {

        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void returnToNewContact() {

        click(By.linkText("home"));
    }


    public void initEditContact() {
        click(By.xpath("//td[8]/a/img"));
                ////table//tbody//tr/td//a[@href='edit.php?id=3']/img
        ////td[8]/a/img
        //css=img[alt=['Edit']"
    }

    public void clickUpdateButton() {
        click(By.name("update"));
    }

    public void initDeleteContact() {
        click(By.name("selected[]"));
        //click(By.xpath("//table//tbody//tr//td//input[@value='10']"));
    }

    public void submitDelete() {
        click(By.cssSelector("input[value='Delete']"));
    }
}
