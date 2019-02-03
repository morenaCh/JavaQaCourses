package ru.stq.pft.addressbook.model;

public class GroupDataContactModification {
    private final String address;
    private final String mobilePhone;
    private final String email;

    public GroupDataContactModification(String address, String mobilePhone, String email) {
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.email = email;
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
}
