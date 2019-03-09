package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;

import static ru.stq.pft.addressbook.tests.BaseTest.app;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void homePage() {
        if (isElementPresent(By.id("maintable"))) {
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
        contactCache = null;
    }

    public void modify(ContactData contact) {
        initEditContactById(contact.getId());
        fillPersonalData(contact, false);
        clickUpdateButton();
        contactCache = null;
        homePage();
    }

    public void delete(int index) {
        selectContact(index);
        submitDelete();
        app.switchTo();
        contactCache = null;
        homePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        submitDelete();
        app.switchTo();
        contactCache = null;
        homePage();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elementsList = wd.findElements(By.name("entry"));
        for (WebElement element : elementsList) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
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

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elementsList = wd.findElements(By.name("entry"));
        for (WebElement element : elementsList) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String address = cells.get(3).getText();
            String email = cells.get(4).getText();
            String phones = cells.get(5).getText();
            contactCache.add(new ContactData()
                    .withId(id).withFirstName(firstname).withLastname(lastname)
                    .withAddress(address).withAllEmail(email)
                    .withAllPhones(phones));
        }
        return contactCache;
    }


    public ContactData infoFormEditForm(ContactData contact) {
        initEditContactById(contact.getId());
        String firstname =  wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address=wd.findElement(By.name("address")).getAttribute("value");
        String email=wd.findElement(By.name("email")).getAttribute("value");
        String email2=wd.findElement(By.name("email2")).getAttribute("value");
        String email3=wd.findElement(By.name("email3")).getAttribute("value");
        String home =  wd.findElement(By.name("home")).getAttribute("value");
        String mobile =  wd.findElement(By.name("mobile")).getAttribute("value");
        String work =  wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname)
                .withLastname(lastname).withAddress(address)
                .withEmail(email).withEmailSecond(email2).withEmailThird(email3)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
}

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
        //wd.findElements(By.cssSelector("[src='icons/pencil.png']")).get(index).click();
    }

    public void selectContactById(int id) {

        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    /*public void initEditContact(ContactData index) {
        wd.findElements(By.cssSelector("[src='icons/pencil.png']")).get(index).click();;
        //click(By.xpath("//td[8]/a/img"));
    }*/

    public void initEditContactById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();

        //wd.findElement(By.xpath(String.format("//input[value='%s']/../../td[8]/a",id))).click();
        //wd.findElement(By.cssSelector(String.format("a[@href='view.php?id=%s'",id))).click();
        //tr[@name='entry']/td/a[@href='view.php?id=58'] moje sciezka przykladowa zeby odstac sie do elementu

    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }


}
