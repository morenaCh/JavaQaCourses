package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stq.pft.addressbook.model.GroupData;

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
    Assert.assertEquals(after.size(), before.size() + 1);//dodajemy 1 element do listy(lista powiekszy sie o jeden po wykonaniu testu

    int max=0;//jesli identyf. na stronie www bedzie wiekszy od 0, zwiekszamy jego wartosc w petli;
    for(GroupData g:after){
    if(g.getId()>max){
      max=g.getId(); //idziemy po petli i znajdujemy na stronie wwww max wartosc;
    }
    group.setId(max); //na koncu cyklu  bedzie najwyzszy identyfikator, pobieramy go i dla nowo powstalej groupy;
    }
    before.add(group);//do listy before dodajemy nowa grupe
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));//zmiana listy w zbior
  }


}
