package StartAtGoogle.PhoneBook;

import java.util.Objects;

public class Name {
    private enum prefix {
        MR, MS
    }

    ;
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) && Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public int compareTo(Name name) {
        int firstNameCompareRes = this.firstName.compareTo(name.firstName);
        int lastNameCompareRes = this.lastName.compareTo(name.lastName);
        return firstNameCompareRes != 0 ? firstNameCompareRes : lastNameCompareRes;

    }

    protected static Object clone(Name name) {
        return new Name(name.firstName, name.lastName);
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
