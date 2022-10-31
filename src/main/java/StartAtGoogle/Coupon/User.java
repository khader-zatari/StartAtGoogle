package StartAtGoogle.Coupon;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    public List<Coupon> couponsList;

    public User(String name) {
        this.name = name;
        this.couponsList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", couponsList=" + couponsList +
                '}';
    }
}
