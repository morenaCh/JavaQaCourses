package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillPersonalData(ContactData contactData, boolean creationM) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddelname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("email"), contactData.getEmail());
        if (creationM) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
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
        click(By.linkText("add new"));
    }

    public void createContact(ContactData contact, boolean creationM) {
        goToContactPage();
        fillPersonalData(contact, creationM);
        clickSubmitButton();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elementsList = wd.findElements(By.name("entry"));
        for (WebElement element : elementsList) {
            List <WebElement>cells=element.findElements(By.tagName("td"));//w poprzednim elemencie szukamy elementów zagnieżdzonych
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String address = cells.get(3).getText();
            String email = cells.get(4).getText();
            String mobilePhone = cells.get(5).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));//"input[name='selected[]'")
            ContactData contact = new ContactData(id, firstname, null, lastname, address, mobilePhone, email, null);
            contacts.add(contact);
        }
        return contacts;
    }

    public List<ContactData> getContactListVideo5() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elementsList = wd.findElements(By.cssSelector("input[name='selected[]'"));//By.id("maintable"));//
        for (WebElement element : elementsList) {
            String name = element.getText();
            ContactData contact = new ContactData(name, null, name, name, name, name, null);
            contacts.add(contact);
        }
        return contacts;
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
        wd.findElements(By.cssSelector("[src='icons/pencil.png']")).get(index).click();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();

    }

}
