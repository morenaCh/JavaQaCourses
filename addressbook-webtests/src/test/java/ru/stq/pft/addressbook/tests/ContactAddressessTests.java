package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressessTests extends BaseTest {
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
    public void testContactAddressess() {
        ContactData contact = app.contact.all().iterator().next();
        ContactData contactInfoFromEditForm=app.contact.infoFormEditForm(contact);

        assertThat(contact.getAddress(),equalTo(mergeAddressess(contactInfoFromEditForm)));
    }

    public String mergeAddressess(ContactData contact) {
        return Arrays.asList(contact.getAddress())
                .stream().filter((s -> !s.equals("")))
                .collect(Collectors.joining("\n"));
    }
}
