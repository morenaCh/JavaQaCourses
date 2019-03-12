package ru.stq.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends BaseTest {

    @DataProvider
    public Iterator<Object[]> validContactsFromXml() throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/contact.xml")));
        String xml="";
        String line=reader.readLine();
        while(line!=null){
            xml +=line;
            line=reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        List<ContactData> contacts=(List<ContactData>) xstream.fromXML(xml);
        return contacts.stream().map((g)->new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/contact.json")));
        String json="";
        String line=reader.readLine();
        while(line!=null){
            json +=line;
            line=reader.readLine();
        }
        Gson gson=new Gson();
        List<ContactData>contacts=gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());//List<GroupData>
        return contacts.stream().map((g)->new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "validContactsFromJson")
    public void testContactCreation(ContactData contact) throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact.all();
        app.contact().create(contact, true);
        /*ContactData contact = new ContactData()
                .withFirstName("Bozena")
                .withMiddelname("Kaminska").withLastname("Jezioranska")
                .withAddress("Miklaszewska 88/41").withMobilePhone("511011011")
                .withEmail("bozena.kam25@gmail.com").withGroup("test1");*/

        app.contact().homePage();
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.contact.all();
        assertThat(after, equalTo(before.
                withAdded(contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
    }



    @Test
    public void testContactWithPhoto() throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact.all();
        File photo=new File("src/test/resources/kwiatek.jpg");
        ContactData contact = new ContactData()
                .withFirstName("Bozena")
                .withMiddelname("Kaminska").withLastname("Jezioranska")
                .withPhoto(photo)
                .withAddress("Miklaszewska 88/41")
                .withGroup("test1");
        app.contact().create(contact, true);
        app.contact().homePage();
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.contact.all();
        assertThat(after, equalTo(before.
                withAdded(contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
    }
    @Test(enabled = false)
    public void testCurrentDir(){
        File currentDir=new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo=new File("src/test/resources/kwiatek.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());


    }
}





