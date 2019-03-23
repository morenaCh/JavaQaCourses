package ru.stq.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Groups;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTests extends BaseTest {

    @BeforeMethod//pamiętaj że w tym teście porównywanie bez nazwiska panieńskiego, nie zapisuję się w szczególach;
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            Groups groups = app.db().groups();
            File photo=new File("src/test/resources/kwiatek.jpg");
            app.contact().create(new ContactData()
                    .withFirstName("Bozena")
                    .withLastname( "Chilecka").withPhoto(photo).withCompany("OBI")
                    .withTitle("Human Recources Manager").withAddress("Ordona 7B/41")
                    .withMobilePhone("567098098").withHomePhone("22445959").withWorkPhone("2253454432")
                    .withEmail("bozena.chilecka@gmail.com").withEmailSecond("bozenakam25@gmail.com")
                    .withEmailThird("bozna@wp.pl").inGroup(groups.iterator().next()),true);
        }
    }

    @Test
    public void testContactDetails() {

        ContactData contact = app.contact().all().iterator().next();
        ContactData contactEditInfoForm = app.contact().infoFormEditForm(contact);
        ContactData contactDetailsInfoForm = app.contact().infoFromDetails(contact);

        assertThat(margeDetails(contactEditInfoForm), equalTo(cleaned(contactDetailsInfoForm.getName())));
    }


    private String margePhonesDetails(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getworkPhone())
                .stream().filter((p) -> !p.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(),contact.getEmailSecond(),contact.getEmailThird())
                .stream().filter((s -> !s.equals("")))
                .map(ContactEmailTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String margeNameAndSurname(ContactData contact) {
        return Arrays.asList((contact.getFirstName() + " " + contact.getLastname())
                .trim(),contact.getTitle(), contact.getCompany(), contact.getAddress())
                .stream().filter((n) -> !n.equals(""))
                .collect(Collectors.joining("\n"));
    }

    private String margeDetails(ContactData contact) {
        return Arrays.asList(margeNameAndSurname(contact),
                margePhonesDetails(contact), mergeEmails(contact))
                .stream().filter((d) -> !d.equals(""))
                .collect(Collectors.joining("\n"));
    }

    public String cleaned(String phone) {
        return phone.replaceAll("[A-Z]: ", "")
                .replaceAll("\n\n", "\n")
                .replaceAll("\n\nMember of: [A-Z,a-z]* *[0-9]*","");
    }


}
