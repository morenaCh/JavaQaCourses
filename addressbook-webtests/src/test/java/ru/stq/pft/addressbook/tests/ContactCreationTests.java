package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends BaseTest {

    @Test
    public void testContactCreation() throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact.all();
        ContactData contact = new ContactData()
                .withFirstName("Bozena")
                .withMiddelname("Kaminska").withLastname("Jezioranska")
                .withAddress("Miklaszewska 88/41").withMobilePhone("511011011")
                .withEmail("bozena.kam25@gmail.com").withGroup("test1");
        app.contact().create(contact, true);
        app.contact().homePage();
        Contacts after = app.contact.all();
        assertThat(after.size(), equalTo(before.size() + 1));


        assertThat(after, equalTo(before.
                withAdded(contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
    }
}





