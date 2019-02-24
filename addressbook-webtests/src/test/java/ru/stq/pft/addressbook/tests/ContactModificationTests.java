package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends BaseTest {

    @Test(enabled=false)
    public void testContactModification(){
        app.goTo().goToHomePage();
        if(!app.contactHelper().isThereAContact()){
            app.contactHelper().createContact(new ContactData("Bozena", "Kaminska", "Jezioranska", "Ordona 7B/41", "676556555", "bozena.chilecka@gmail.com","test1"),true);
        }
        List<ContactData> before = app.contactHelper.getContactList();
        app.contactHelper().selectContact(before.size() - 1 );
        //app.contactHelper.initEditContact();
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

        //1 version Liczenie elementow na stronie www(video 3,4 ) i wybór elemtu po indeksie
        /*app.goTo().goToHomePage();
        if(!app.contactHelper().isThereAContact()){
            app.contactHelper().createContact(new ContactData("Bozena", "Kaminska", "Chilecka", "Ordona 7B/41", "567-098-098", "bozena.chilecka@gmail.com","test1"),true);
        }
        int before=app.contactHelper.getContactCount();
        app.contactHelper().selectContact(before - 1 );
        app.contactHelper.initEditContact();
        app.contactHelper.fillPersonalData( new ContactData("Bozena", "Kaminska","Chilecka", "Miklaszewska 88/41", "511-011-011", "bozena.kam25@gmail.com",null),false);
        app.contactHelper.clickUpdateButton();
        app.contactHelper().returnToNewContact();
        int after=app.contactHelper.getContactCount();
        Assert.assertEquals(after,before);*/

        //2 version -video 5, zamieniamy int na listę i porównujemy tylko rozmiary listy
        /*
        app.goTo().goToHomePage();
        if(!app.contactHelper().isThereAContact()){
            app.contactHelper().createContact(new ContactData("Bozena", "Kaminska", "Chilecka", "Ordona 7B/41", "567-098-098", "bozena.chilecka@gmail.com","test1"),true);
        }
        List<ContactData> before = app.contactHelper.getContactListVideo5();
        app.contactHelper().selectContact(before.size() - 1 );;
        app.contactHelper.initEditContact();
        app.contactHelper.fillPersonalData( new ContactData("Bozena", "Kaminska","Chilecka", "Miklaszewska 88/41", "511-011-011", "bozena.kam25@gmail.com",null),false);
        app.contactHelper.clickUpdateButton();
        app.contactHelper().returnToNewContact();
        List<ContactData> after = app.contactHelper.getContactListVideo5();
        Assert.assertEquals(after.size(), before.size());
         */

