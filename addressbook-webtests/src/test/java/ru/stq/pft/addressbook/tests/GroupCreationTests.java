package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;


public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    List<GroupData>before=app.group().list();
    GroupData group=new GroupData().withName("test2");
    app.group().create(group);
    List<GroupData>after=app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);//add 1 elem. do listy(lista powiekszy sie o 1 po wyk. testu

    before.add(group);
    Comparator<? super GroupData> ById=(g1,g2)->Integer.compare(g1.getId(),g2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(before,after);
  }


}
