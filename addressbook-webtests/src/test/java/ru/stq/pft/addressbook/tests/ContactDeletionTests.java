package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactDeletionTests extends BaseTest {

    @Test(enabled=false)
    public void testContactDeletion() {
        app.goTo().goToHomePage();
        if (!app.contactHelper().isThereAContact()) {
            app.contactHelper().createContact(new ContactData("Bozena", "Kaminska", "Chilecka", "Ordona 7B/41", "567098098", "bozena.chilecka@gmail.com", "test1"), true);
        }
        List<ContactData> before = app.contactHelper.getContactList();
        app.contactHelper().selectContact(before.size() - 1);
        app.contactHelper.submitDelete();
        app.switchTo();
        app.contactHelper().returnToNewContact();
        List<ContactData> after = app.contactHelper.getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);//porównujemy liczbę elementów listy

        before.remove(before.size() - 1);
        Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));

        /*testowy famework, potrafi porównywac listy bez jakolwiek cyklu(pętli)
        before.remove(before.size() - 1);
        for (int i=0;i<after.size();i++){
            Assert.assertEquals(before.get(i), after.get(i));
        }*/

    }
}


//1 version Liczenie elementow na stronie www(video 3,4 ) i wybór elemtu po indeksie
        /*app.goTo().goToHomePage();
        if(!app.contactHelper().isThereAContact()){
            app.contactHelper().createContact(new ContactData("Bozena", "Kaminska", "Chilecka", "Ordona 7B/41", "567-098-098", "bozena.chilecka@gmail.com","test1"),true);
        }
        int before=app.contactHelper.getContactCount();
        app.contactHelper().selectContact(before - 1 );
        app.contactHelper.submitDelete();
        app.switchTo();
        app.contactHelper().returnToNewContact();
        int after=app.contactHelper.getContactCount();
        Assert.assertEquals(after,before-1);*/

//2 version -video 5, zamieniamy int na listę i porównujemy tylko rozmiary listy
        /*
         app.goTo().goToHomePage();
        if(!app.contactHelper().isThereAContact()){
            app.contactHelper().createContact(new ContactData("Bozena", "Kaminska", "Chilecka", "Ordona 7B/41", "567-098-098", "bozena.chilecka@gmail.com","test1"),true);
        }
        List<ContactData> before = app.contactHelper.getContactListVideo5();
        app.contactHelper().selectContact(before.size() - 1 );
        app.contactHelper.submitDelete();
        app.switchTo();
        app.contactHelper().returnToNewContact();
        List<ContactData> after = app.contactHelper.getContactListVideo5();
        Assert.assertEquals(after.size(), before.size() - 1);
         */

