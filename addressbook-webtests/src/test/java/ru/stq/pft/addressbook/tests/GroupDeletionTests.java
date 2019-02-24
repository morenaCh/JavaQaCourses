package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends BaseTest {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size()==0) {
            app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
        }
    }

    @Test
    public void testGroupDeletion() throws Exception {
        List<GroupData> before = app.group().list();
        int index=before.size() - 1;
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);//prównujemy ilość elementów listy before,after

        before.remove(index);//porownujemy 2 listy before,after (po name groupy i dentyfikatorze)
        Assert.assertEquals(before, after);

    }

}


