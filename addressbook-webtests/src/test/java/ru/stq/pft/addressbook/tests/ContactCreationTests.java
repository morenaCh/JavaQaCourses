package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

public class ContactCreationTests extends BaseTest{

  @Test
  public void testContactCreation() throws Exception {
      app.contactHelper().createContact(new ContactData("Bozena", "Kaminska", "Chilecka", "Ordona 7B/41", "567-098-098", "bozena.chilecka@gmail.com","test1"),true);
    app.contactHelper().returnToNewContact();




  }
}
