package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends BaseTest {

    @Test
    public void testContactDeletion(){
        app.getNavigationHelper().goToHomePage();
        app.contactHelper.initDeleteContact();
        app.contactHelper.submitDelete();
        app.switchTo();
        app.contactHelper().returnToNewContact();
    }
}
