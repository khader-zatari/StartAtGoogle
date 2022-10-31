package StartAtGoogle.PhoneBook;

import java.util.Objects;

public class Contact {
    private Name name;
    private PhoneNumber phoneNumber;

    public Contact(Name name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(phoneNumber, contact.phoneNumber);
    }

    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

    protected static Object clone(Contact contact) {
        return new Contact(contact.name, contact.phoneNumber);
    }

    public int compareTo(Contact contact) {
        return name.compareTo(contact.name) == 0 ? phoneNumber.compareTo(contact.phoneNumber) : name.compareTo(contact.name);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name=" + name +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
