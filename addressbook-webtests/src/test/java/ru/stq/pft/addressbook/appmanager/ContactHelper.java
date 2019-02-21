package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stq.pft.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillPersonalData(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddelname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("email"), contactData.getEmail());
        if(creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }else{
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void clickSubmitButton() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void returnToNewContact() {
        click(By.linkText("home"));
    }


    public void initEditContact() {
        click(By.cssSelector("[src='icons/pencil.png']"));
        //click(By.xpath("//td[8]/a/img"));
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

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//td[8]/a/img"));
    }

    public void goToContactPage() {
        click(By.linkText("add new"));}

    public void createContact(ContactData contact,boolean creationM) {
        goToContactPage();
        fillPersonalData(contact,creationM);
        clickSubmitButton();
    }

}
