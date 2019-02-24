package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.GroupData;
import java.util.Set;

public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Set<GroupData> before=app.group().all();
    GroupData group=new GroupData().withName("test2");
    app.group().create(group);
    Set<GroupData>after=app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);//add 1 elem. do listy(lista powiekszy sie o 1 po wyk. testu

    group.withId(after.stream().mapToInt(g->g.getId()).max().getAsInt());//tutaj powinien obliczac sie max id;zamieniamy potok obiektow w potok liczb(id);//anonimowa funkcja, która jako parametr przyjmuje grupę, a jako wynik wydaje id tej groupy, nastepnie wywolujemy metode max i przeksztalcamy wynik w liczbe calkowita.
    before.add(group);
    Assert.assertEquals(before,after);
  }


}
