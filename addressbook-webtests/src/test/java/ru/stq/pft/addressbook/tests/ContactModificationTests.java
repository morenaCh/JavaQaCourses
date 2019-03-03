package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends BaseTest {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().goToHomePage();
        if(!app.contactHelper().isThereAContact()){
            app.contactHelper().createContact(new ContactData("Bozena", "Kaminska", "Jezioranska", "Ordona 7B/41", "676556555", "bozena.chilecka@gmail.com","test1"),true);
        }
    }

    @Test
    public void testContactModification(){
        List<ContactData> before = app.contactHelper.getContactList();
        app.contactHelper().selectContact(before.size() - 1 );
        app.contactHelper.initEditContact(before.size() - 1 );
        ContactData contact=new ContactData(before.get(before.size() - 1).getId(),"Bozena", "Kaminska","Jezioranska", "Miklaszewska 88/41", "511011011", "bozena.kam25@gmail.com",null);
        app.contactHelper.fillPersonalData(contact,false);
        app.contactHelper.clickUpdateButton();
        app.contactHelper().returnToNewContact();
        List<ContactData> after = app.contactHelper.getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1 );//przed porównaniem usuwamy, element który zosanie usunięty
        before.add(contact);//i dodajemy element, który zostanie dodany
        Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));//przekształcamy listę w zbiór
    }
}


