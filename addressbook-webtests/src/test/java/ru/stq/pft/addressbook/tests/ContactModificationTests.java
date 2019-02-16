package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

public class ContactModificationTests extends BaseTest {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToHomePage();
        if(!app.contactHelper().isThereAContact()){
            app.contactHelper().createContact(new ContactData("Bozena", "Kaminska", "Chilecka", "Ordona 7B/41", "567-098-098", "bozena.chilecka@gmail.com","test1B"),true);
        }
        app.contactHelper.initEditContact();
        app.contactHelper.fillPersonalData( new ContactData("Bozena", "Kaminska","Chilecka", "Miklaszewska 88/41", "511-011-011", "bozena.kam25@gmail.com",null),false);
        app.contactHelper.clickUpdateButton();
        app.contactHelper().returnToNewContact();
    }
}
