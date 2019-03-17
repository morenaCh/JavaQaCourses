package ru.stq.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressessTests extends BaseTest {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            File photo=new File("src/test/resources/kwiatek.jpg");
            app.contact().create(new ContactData()
                    .withFirstName("Bozena").withMiddelname("Kaminska")
                    .withLastname( "Chilecka").withPhoto(photo).withCompany("OBI")
                    .withTitle("Human Recources Manager").withAddress("Ordona 7B/41")
                    .withMobilePhone("567098098").withHomePhone("22445959").withWorkPhone("2253454432")
                    .withEmail("bozena.chilecka@gmail.com").withEmailSecond("bozenakam25@gmail.com")
                    .withEmailThird("bozna@wp.pl")
                    .withGroup("test1"), true);
        }
    }

    @Test
    public void testContactAddressess() {
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm=app.contact.infoFormEditForm(contact);

        assertThat(contact.getAddress(),equalTo(mergeAddressess(contactInfoFromEditForm)));
    }

    public String mergeAddressess(ContactData contact) {
        return Arrays.asList(contact.getAddress())
                .stream().filter((s -> !s.equals("")))
                .collect(Collectors.joining("\n"));
    }
}
