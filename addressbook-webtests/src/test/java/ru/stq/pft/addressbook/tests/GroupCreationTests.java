package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stq.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends BaseTest {



  @Test //to change
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    List<GroupData>before=app.getGroupHelper().getGroupList();
    GroupData group=new GroupData("test1BBBB", "test2A", "test3A");
    app.getGroupHelper().createGroup(group);
    List<GroupData>after=app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);//add 1 elem. do listy(lista powiekszy sie o 1 po wyk. testu

    before.add(group);
    Comparator<? super GroupData> ById=(g1,g2)->Integer.compare(g1.getId(),g2.getId());
    before.sort(ById);//do listy before dodajemy nowa grupe
    after.sort(ById);
    Assert.assertEquals(before,after);
  }


}
