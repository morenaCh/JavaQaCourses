package ru.stq.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Contacts;
import ru.stq.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends BaseTest {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            Groups groups = app.db().groups();
            File photo=new File("src/test/resources/kwiatek.jpg");
            app.contact().create(new ContactData()
                    .withFirstName("Bozena").withMiddelname("Kaminska")
                    .withLastname( "Chilecka").withPhoto(photo).withCompany("OBI")
                    .withTitle("Human Recources Manager").withAddress("Ordona 7B/41")
                    .withMobilePhone("567098098").withHomePhone("22445959").withWorkPhone("2253454432")
                    .withEmail("bozena.chilecka@gmail.com").withEmailSecond("bozenakam25@gmail.com")
                    .withEmailThird("bozna@wp.pl").inGroup(groups.iterator().next()),true);
        }
    }

    @Test
    public void testContactModification(){
        //before where compare list by WebInterface method equals and hascode compare by id,firstname,lastname,address
        Contacts before = app.db().contacts();
        File photo=new File("src/test/resources/kwiatek.jpg");
        ContactData modifiedContact=before.iterator().next();
        ContactData contact=new ContactData()
                .withId(modifiedContact.getId())
                .withFirstName("Bozena").withMiddelname("Kaminska")
                .withLastname( "Chilecka").withCompany("OBI").withPhoto(photo).withCompany("OBI")
                .withTitle("Human Recources Manager").withAddress("Ordona 7B/41")
                .withMobilePhone("567098098").withHomePhone("22445959").withWorkPhone("2253454432")
                .withEmail("bozena.chilecka@gmail.com").withEmailSecond("bozenakam25@gmail.com")
                .withEmailThird("bozna@wp.pl");
        app.goTo().homePage();
        app.contact.modify(contact);
        assertThat(app.group().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


}


