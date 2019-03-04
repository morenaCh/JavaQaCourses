package ru.stq.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends BaseTest {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size()==0) {
            app.contact().create(new ContactData()
                    .withFirstName("Bozena").withMiddelname("Kaminska")
                    .withLastname( "Chilecka").withAddress("Ordona 7B/41")
                    .withMobilePhone("567098098").withEmail("bozena.chilecka@gmail.com")
                    .withGroup("test1"), true);
        }
    }

    @Test
    public void testContactModification(){
        Contacts before = app.contact.all();
        ContactData modifiedContact=before.iterator().next();
        ContactData contact=new ContactData()
                .withId(modifiedContact.getId())
                .withFirstName("Bozena").withMiddelname( "Kaminska")
                .withLastname("Jezioranska").withAddress("Miklaszewska 88/41")
                .withMobilePhone("511011011").withEmail( "bozena.kam25@gmail.com")
                .withGroup(null);
        app.contact.modify(contact);
        Contacts after = app.contact.all();
        assertThat(after.size(), equalTo(before.size()));

        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


}


