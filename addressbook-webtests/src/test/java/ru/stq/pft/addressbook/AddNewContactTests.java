package ru.stq.pft.addressbook;

import org.testng.annotations.Test;

public class AddNewContactTests extends BaseTest{

  @Test
  public void testAddNewContacts() throws Exception {
    initAddNewContact();
    fillPersonalData(new GroupDataContact("Bozena", "Kaminska", "Chilecka", "Ordona 7B/41", "567-098-098", "bozena.kaminska@gmail.com"));
    clickSubmitButton();
    returnToNewContact();
    Logout();
  }


}
