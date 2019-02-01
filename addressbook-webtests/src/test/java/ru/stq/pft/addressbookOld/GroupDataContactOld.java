package ru.stq.pft.addressbookOld;

public class GroupDataContactOld {
    private final String firstName;
    private final String middelname;
    private final String lastname;
    private final String address;
    private final String mobilePhone;
    private final String email;

    public GroupDataContactOld(String firstName, String middelname, String lastname, String address, String mobilePhone, String email) {
        this.firstName = firstName;
        this.middelname = middelname;
        this.lastname = lastname;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.email = email;
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
}
