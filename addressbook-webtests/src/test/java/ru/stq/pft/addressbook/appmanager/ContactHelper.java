package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ru.stq.pft.addressbook.tests.BaseTest.app;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void homePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
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

    public void create(ContactData contact, boolean creationM) {
        goToContactPage();
        fillPersonalData(contact, creationM);
        clickSubmitButton();
    }

    public void modify(ContactData contact) {
        initEditContactById(contact.getId());
        fillPersonalData(contact,false);
        clickUpdateButton();
        homePage();
    }

    public void delete(int index) {
        selectContact(index);
        submitDelete();
        app.switchTo();
        homePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        submitDelete();
        app.switchTo();
        homePage();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elementsList = wd.findElements(By.name("entry"));
        for (WebElement element : elementsList) {
            List <WebElement>cells=element.findElements(By.tagName("td"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String address = cells.get(3).getText();
            String email = cells.get(4).getText();
            String mobilePhone = cells.get(5).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastname(lastname).withAddress(address).withMobilePhone(mobilePhone).withEmail(email));
        }
        return contacts;
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elementsList = wd.findElements(By.name("entry"));
        for (WebElement element : elementsList) {
            List <WebElement>cells=element.findElements(By.tagName("td"));//w poprzednim elemencie szukamy elementów zagnieżdzonych
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String address = cells.get(3).getText();
            String email = cells.get(4).getText();
            String mobilePhone = cells.get(5).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastname(lastname).withAddress(address).withMobilePhone(mobilePhone).withEmail(email));
        }
        return contacts;
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
        //wd.findElements(By.cssSelector("[src='icons/pencil.png']")).get(index).click();
    }

    public void selectContactById(int id) {

        wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
    }

    /*public void initEditContact(ContactData index) {
        wd.findElements(By.cssSelector("[src='icons/pencil.png']")).get(index).click();;
        //click(By.xpath("//td[8]/a/img"));
    }*/

    public void initEditContactById(int id) {
        WebElement chx = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = chx.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();

        //tr[@name='entry']/td/a[@href='view.php?id=58'] moje sciezka przykladowa zeby odstac sie do elementu

    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


}
