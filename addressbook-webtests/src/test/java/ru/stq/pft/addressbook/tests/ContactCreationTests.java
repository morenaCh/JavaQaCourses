package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends BaseTest {

    @Test(enabled=false)
    public void testContactCreation() throws Exception {
        app.goTo().goToHomePage();
        List<ContactData> before = app.contactHelper.getContactList();
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Bozena", "Kaminska", "Namysłowska", "Ordona 7B/41", "567098098", "bozena.chilecka@gmail.com", "test1");
        app.contactHelper().createContact(contact,true);
        app.contactHelper().returnToNewContact();
        List<ContactData> after = app.contactHelper.getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max1=0;
        for(ContactData c:after){
            if(c.getId()>max1){
                max1=c.getId();
            }
        }contact.setId(max1);

        before.add(contact);
        Assert.assertEquals(after,before);

    }
}
        /*before.add(contact);
        Comparator<? super ContactData> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);*/


        //1 version Liczenie elementow na stronie www(video 3,4 ) i wybór elementu po indeksie
        /*app.goTo().goToHomePage();
        int before=app.contactHelper.getContactCount();
        ContactData contact = new ContactData("Bozena", "Kaminska", "Namysłowska", "Ordona 7B/41", "567-098-098", "bozena.chilecka@gmail.com", "test1");
        app.contactHelper().createContact(contact,true);
        app.contactHelper().returnToNewContact();
        int after=app.contactHelper.getContactCount();
        Assert.assertEquals(after,before+1);*/

        //2 version -video 5, zamieniamy int na listę i porównujemy tylko rozmiary listy
        /*
         app.goTo().goToHomePage();
        List<ContactData> before = app.contactHelper.getContactListVideo5();
        System.out.println("Wielkość listy przed "+before.size());
        ContactData contact = new ContactData("Bozena", "Kaminska", "Namysłowska", "Ordona 7B/41", "567-098-098", "bozena.chilecka@gmail.com", "test1");
        app.contactHelper().createContact(contact,true);
        app.contactHelper().returnToNewContact();
        List<ContactData> after = app.contactHelper.getContactListVideo5();
        System.out.println("Wielkość listy po "+after.size());
        Assert.assertEquals(after.size(), before.size() + 1);
         */

        //Sposoby na poróœnywanie 3 wersji:
        /*
        //1 sposob
        int max1=0;
        for(ContactData c:after){
            if(c.getId()>max1){
                max1=c.getId();
            }
        }contact.setId(max1);
         */

        /*

         */

