package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends BaseTest {

    @Test
    public void testGroupDeletion() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAgroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1B", "test2A", "test3A"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
