package ru.stq.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends BaseTest{

    @Test //test failed
    public void testGroupModification(){
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAgroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        }
        List<GroupData> before=app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);//0 -first element; before-1 - ostatni element
        app.getGroupHelper().initGroupModification();
        GroupData group=new GroupData(before.get(before.size()-1).getId(),"test1", "test2", "test3");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData>after=app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() );//liczba elementow w liscie zostaje taka sama przed i po wykonaniu testu;

        before.remove(before.size()-1);
        before.add(group);
        Comparator<? super GroupData> ById=(g1,g2)->Integer.compare(g1.getId(),g2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before,after);///przeksztalcamy listyw zbiory, gdyz zbiory sa nieuporzadkowanymi kolekcjami i w ten sposob bedziemy mogli je porownac po modyfikacji;
    }

}
