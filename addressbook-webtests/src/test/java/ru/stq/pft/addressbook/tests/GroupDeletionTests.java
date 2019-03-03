package ru.stq.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.GroupData;
import ru.stq.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends BaseTest {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size()==0) {
            app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
        }
    }

    @Test(enabled=false)
    public void testGroupDeletion() throws Exception {
        Groups before = app.group().all();
        GroupData deletedGroup=before.iterator().next();//zostanie zwrocony  elem. zbioru,ktory losowo bedzie znaleziony;
        app.group().delete(deletedGroup);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size() - 1);//prównujemy ilość elementów listy before,after
        assertThat(after, equalTo(before.without(deletedGroup)));


    }

}


