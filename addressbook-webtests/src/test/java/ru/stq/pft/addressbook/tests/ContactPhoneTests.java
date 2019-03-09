package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends BaseTest{
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
    public void testContactPhones() {
        ContactData contact = app.contact.all().iterator().next();
        ContactData contactInfoFromEditForm=app.contact.infoFormEditForm(contact);

        assertThat(contact.getAllPhones(),equalTo(mergePhones(contactInfoFromEditForm)));
    }

    public static String cleaned(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }

    public String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(),contact.getworkPhone())
                .stream().filter((s -> !s.equals("")))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }
}
