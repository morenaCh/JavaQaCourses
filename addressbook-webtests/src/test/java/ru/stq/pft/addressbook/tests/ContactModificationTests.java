package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

public class ContactModificationTests extends BaseTest {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToHomePage();
        app.contactHelper.initEditContact();
        app.contactHelper.fillPersonalData( new ContactData("Bozena", "Kaminska","Chilecka", "Mklaszewska 88/41", "511-011-011", "bozena.kam25@gmail.com"));
        app.contactHelper.clickUpdateButton();
        app.contactHelper().returnToNewContact();
    }
}
