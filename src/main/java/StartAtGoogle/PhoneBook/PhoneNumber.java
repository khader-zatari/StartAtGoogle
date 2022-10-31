package StartAtGoogle.PhoneBook;

import java.util.Objects;

public class PhoneNumber {
    private final String areaCode;
    private final String number;

    public PhoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber phoneNumber = (PhoneNumber) o;
        return Objects.equals(areaCode, phoneNumber.areaCode) && Objects.equals(number, phoneNumber.number);
    }

    public int hashCode() {

        return Objects.hash(areaCode, number);
    }

    public int compareTo(PhoneNumber phoneNumber) {
        return Integer.compare(Integer.parseInt(number), Integer.parseInt(phoneNumber.number));
    }

    protected static Object clone(PhoneNumber phoneNumber) {
        return new PhoneNumber(phoneNumber.areaCode, phoneNumber.number);
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "areaCode='" + areaCode + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
