package edu.ualr.intentsassignment.model;

// TODO 05. Modify the Contact class, so you can use it to exchange Contact data between ContactFormActivity and ContactInfoActivity
// Changing the Contact class to implement the Parcelable interface
// I'm doing this so my intent can pass a Contact object from the contactForm to the contactInfo

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String website;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String phoneNumber, String emailAddress, String address, String website) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.website = website;
    }

    protected Contact(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        phoneNumber = in.readString();
        emailAddress = in.readString();
        address = in.readString();
        website = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(phoneNumber);
        dest.writeString(emailAddress);
        dest.writeString(address);
        dest.writeString(website);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
