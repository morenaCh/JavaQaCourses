package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.GroupDataContact;
import ru.stq.pft.addressbook.model.GroupDataContactModification;

public class ContactModificationTests extends BaseTest {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToHomePage();
        app.contactHelper.initEditContact();
        app.contactHelper.fillPersonalModificationData( new GroupDataContactModification("Mklaszewska 88/41", "511-011-011", "bozena.kam25@gmail.com"));
        app.contactHelper.clickUpdateButton();
        app.contactHelper().returnToNewContact();
    }
}
