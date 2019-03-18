package ru.stq.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

    @XStreamOmitField
    @Id
    @Column(name = "id")
    public int id = Integer.MAX_VALUE;

    @Expose
    @Column(name = "firstname")
    public String firstName;

    @Expose
    @Column(name = "middlename")
    public String middelname;

    @Expose
    @Column(name = "lastname")
    public String lastname;

    @Column(name = "company")
    public String company;

    @Column(name = "title")
    public String title;

    @Expose
    @Column(name = "address")
    @Type(type = "text")
    public String address;

    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    public String mobilePhone;

    @Column(name = "home")
    @Type(type = "text")
    public String homePhone;

    @Column(name = "work")
    @Type(type = "text")
    public String workPhone;

    @Transient
    public String allPhones;

    @Expose
    @Column(name = "email")
    @Type(type = "text")
    public String email;

    @Column(name = "email2")
    @Type(type = "text")
    public String emailSecond;

    @Column(name = "email3")
    @Type(type = "text")
    public String emailThird;

    @Transient
    public String allEmail;

    @Column(name = "photo")
    @Type(type = "text")
    public String photo;

    public Groups getGroups() {
        return new Groups(groups);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups", joinColumns=@JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name="group_id"))
    private Set<GroupData> groups=new HashSet<GroupData>();

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddelname() {
        return middelname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getworkPhone() {
        return workPhone;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailSecond() {
        return emailSecond;
    }

    public String getEmailThird() {
        return emailThird;
    }

    public String getAllEmail() {
        return allEmail;
    }

    public File getPhoto() {
        if (photo == null) {
            return null;
        }
        return new File(photo);
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withMiddelname(String middelname) {
        this.middelname = middelname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }


    public ContactData withAllPhones(String withAllPhones) {
        this.allPhones = withAllPhones;
        return this;
    }


    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmailSecond(String emailSecond) {
        this.emailSecond = emailSecond;
        return this;
    }

    public ContactData withEmailThird(String emailThird) {
        this.emailThird = emailThird;
        return this;
    }

    public ContactData withAllEmail(String allEmail) {
        this.allEmail = allEmail;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(middelname, that.middelname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(company, that.company) &&
                Objects.equals(title, that.title) &&
                Objects.equals(address, that.address) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(homePhone, that.homePhone) &&
                Objects.equals(workPhone, that.workPhone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(emailSecond, that.emailSecond) &&
                Objects.equals(emailThird, that.emailThird);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middelname, lastname, company, title, address, mobilePhone, homePhone, workPhone, email, emailSecond, emailThird);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middelname='" + middelname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", company='" + company + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", email='" + email + '\'' +
                ", emailSecond='" + emailSecond + '\'' +
                ", emailThird='" + emailThird + '\'' +
                '}';
    }


    public ContactData inGroup(GroupData group) {
        groups.add(group);
        return this;

    }
}
