package ru.stq.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends BaseTest {

  @Test
  public void testGroupDeletion() throws Exception {
    goToGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
  }

}
