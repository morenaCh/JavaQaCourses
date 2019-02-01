package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.GroupDataContact;

public class AddNewContactTests extends BaseTest{

  @Test
  public void testAddNewContacts() throws Exception {
    app.initAddNewContact();
    app.getGroupHelper().fillPersonalData(new GroupDataContact("Bozena", "Kaminska", "Chilecka", "Ordona 7B/41", "567-098-098", "bozena.kaminska@gmail.com"));
    app.clickSubmitButton();
    app.returnToNewContact();
  }


}
