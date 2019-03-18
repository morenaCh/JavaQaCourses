package ru.stq.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stq.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    @Parameter(names="-c",description="Contact count")
    public int count;

    @Parameter(names="-f",description="Target file")
    public String file;

    @Parameter(names="-d",description="Data format")
    public String format;

    public static void main(String[]args) throws IOException {//Program arguments:10 src/test/resources/contact.csv
        ContactDataGenerator generator=new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try{
            jCommander.parse(args);
        }catch(ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContact(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognised format " + format);
        }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        //https://github.com/google/gson/blob/master/UserGuide.md
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try(Writer writer=new FileWriter(file)){
            writer.write(json);
        }
    }


    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        //http://x-stream.github.io/
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        try(Writer writer=new FileWriter(file)){
            writer.write(xml);
        }
    }

    private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        try(Writer writer=new FileWriter(file)) {
            for (ContactData contact : contacts) {
                writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;\n",
                        contact.getFirstName(), contact.getMiddelname(), contact.getLastname(), contact.getAddress(),
                        contact.getMobilePhone(), contact.getEmail()));
                        //contact.getGroup()));
            }
        }
    }

    private List<ContactData> generateContact(int count) {
        List<ContactData>contacts=new ArrayList<ContactData>();
        for(int i=0;i<count;i++) {
            contacts.add(new ContactData()
                    .withFirstName(String.format("FirstNamen%s", i))
                    .withMiddelname(String.format("Middelname%s", i))
                    .withLastname(String.format("Lastname%s", i))
                    .withAddress(String.format("Address 88/4%s", i))
                    .withMobilePhone(String.format("51101101%s",i))
                    .withEmail(String.format("bozena.kam%s@gmail.com", i)));
                    //.withGroup(String.format("test %s",i)));
        }

        return contacts;
    }

}
