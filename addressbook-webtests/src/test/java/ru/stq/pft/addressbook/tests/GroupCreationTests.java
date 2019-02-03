package ru.stq.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stq.pft.addressbook.model.GroupData;


public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1A", "test2A", "test3A"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }


}
