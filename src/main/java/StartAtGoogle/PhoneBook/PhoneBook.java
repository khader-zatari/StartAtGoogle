package StartAtGoogle.PhoneBook;

import java.util.List;

public class PhoneBook {
    private List<Contact> contactList;
    private final String phoneBookName;

    public PhoneBook(String phoneBookName) {
        this.phoneBookName = phoneBookName;
    }
    public void setContactList(Contact contact) {
        this.contactList.add(contact);
    }

    public List<Contact> getContactList() {
        return contactList;
    }



    public List<Contact> getContact() {
        return contactList;
    }

    public String getPhoneBookName() {
        return phoneBookName;
    }

    public void addContact(Contact contact) {
        this.contactList.add(contact);
    }


}
