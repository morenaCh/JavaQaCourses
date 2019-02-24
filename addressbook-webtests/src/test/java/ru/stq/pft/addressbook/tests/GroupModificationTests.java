package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends BaseTest{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size()==0) {
            app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
        }
    }

    @Test //test failed
    public void testGroupModification(){
        List<GroupData> before=app.group().list();
        int index=before.size()-1;//0 -first element; before-1 - ostatni element
        GroupData group=new GroupData()
                .withId(before.get(index).getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modify(index, group);
        List<GroupData>after=app.group().list();
        Assert.assertEquals(after.size(), before.size());//liczba elementow jest taka sama przed i po wykonaniu testu;

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> ById=(g1,g2)->Integer.compare(g1.getId(),g2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before,after);
    }

}
