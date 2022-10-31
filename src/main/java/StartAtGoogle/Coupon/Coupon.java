package StartAtGoogle.Coupon;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

//take care of exception in invalide thing.
//take care of the id and the value that they are positives.
//you should take care of the Date that the generated date is before today in every place generated.
//here the teacher impliminted an equal and hashmap functions because if someone else want to do something by the copun and make something in it and implement the compair
//localDate shouldnot make a definssive copy, Date should make a definssive copy. localDate in immutable (every thing is final) -> he cant change itself then return it "it's final".
//the expiry date is from today + x dates.
//constructor can be class private.


public class Coupon {
    private final int id;
    private final LocalDate date;
    private final int value;

    public int getId() {
        return id;
    }

    public LocalDate getDate() {

        // you should make the  definsive copy for the date.
        ////// return new Date(date); //something like that.
        return date;
    }

    public int getValue() {
        return value;
    }

    public Coupon(int id, LocalDate date, int value) {
        this.id = id;
        // you should make the  definsive copy for the date.
        ////// this.date = new Date(date); //something like that.
        this.date = date;
        this.value = value;
    }

    public static Coupon generateRandomCoupon() {


        int randomId = ThreadLocalRandom.current().nextInt(10000);
        int value = ThreadLocalRandom.current().nextInt(250);
//here i have a problem in the date. the coupon should be after today and not before.

        LocalDate from = LocalDate.of(2016, 1, 1);
        LocalDate to = LocalDate.of(2017, 1, 1);
        long days = from.until(to, ChronoUnit.DAYS);
        long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
        LocalDate randomDate = from.plusDays(randomDays);


        return new Coupon(randomId, randomDate, value);

    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", date=" + date +
                ", value=" + value +
                '}';
    }
}
