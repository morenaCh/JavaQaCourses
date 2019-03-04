package ru.stq.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends BaseTest {

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
    public void testContactDeletion() {

        Contacts before = app.contact.all();
        ContactData deletedContact=before.iterator().next();
        app.contact.delete(deletedContact);
        Contacts after = app.contact.all();
        assertThat(after.size(), equalTo(before.size() - 1));

        assertThat(after, equalTo(before.without(deletedContact)));
    }
}


