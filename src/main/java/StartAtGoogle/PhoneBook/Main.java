package StartAtGoogle.PhoneBook;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook("new Phone Book");
        Name name = new Name("khader", "Zatari");
        Name name1 = new Name("khader", "Zatari");

        PhoneNumber newPhoneNumber = new PhoneNumber("972", "525030435");
        PhoneNumber newPhoneNumber1 = new PhoneNumber("972", "525030435");
        Contact newContact = new Contact(name, newPhoneNumber);
        Contact newContact1 = new Contact(name1, newPhoneNumber1);


        System.out.println(newContact.compareTo(newContact1));
        System.out.println(newContact.equals(newContact1));
        System.out.println(Contact.clone(newContact));
        System.out.println(newContact.toString());
        System.out.println(newContact.hashCode());


    }
}
