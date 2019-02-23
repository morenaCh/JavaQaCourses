package ru.stq.pft.addressbook.model;

import org.openqa.selenium.WebElement;

import java.util.Objects;

public class ContactData {



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(address, that.address) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastname, address, mobilePhone, email);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'';
    }

    public void setId(int id) {
        this.id = id;
    }

    public  int id;
    public String firstName;
    public String middelname;
    public String lastname;
    public String address;
    public String mobilePhone;
    public String email;
    public String group;

    public ContactData(String firstName, String middelname, String lastname, String address, String mobilePhone, String email, String group) {
        this.id=Integer.MAX_VALUE;
        this.firstName = firstName;
        this.middelname = middelname;
        this.lastname = lastname;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.group = group;
    }

    public ContactData(int id,String firstName, String middelname, String lastname, String address, String mobilePhone, String email, String group) {
        this.id=id;
        this.firstName = firstName;
        this.middelname = middelname;
        this.lastname = lastname;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.group = group;
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

    public String getAddress() {
        return address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return this.group;
    }

    public int getId() {
        return id;
    }

}
