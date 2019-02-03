package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.GroupDataContact;

public class ContactCreationTests extends BaseTest{

  @Test
  public void testAddNewContacts() throws Exception {
    app.contactHelper().goToContactPage();
    app.contactHelper().fillPersonalData(new GroupDataContact("Bozena", "Kaminska", "Chilecka", "Ordona 7B/41", "567-098-098", "bozena.chilecka@gmail.com"));
    app.contactHelper().clickSubmitButton();
    app.contactHelper().returnToNewContact();
  }


}
