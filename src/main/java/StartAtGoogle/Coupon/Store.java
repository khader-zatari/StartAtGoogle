package StartAtGoogle.Coupon;

import java.time.LocalDate;

public class Store {
    private String storeName;

    public Store(String storeName) {
        this.storeName = storeName;
    }

    public void assignCouponToUser(Coupon coupon, User user) {
        user.couponsList.add(coupon);
    }

    public int useCouponForUserById(int id, User user) {
        if (user == null) {
            return 0;
        }
        for (Coupon tempCoupon : user.couponsList) {
            if (tempCoupon.getId() == id) {
                user.couponsList.remove(tempCoupon);
                System.out.println("iam here" + user.couponsList);
                return tempCoupon.getValue();
            }

        }
        return 0;

    }

    public int useCouponForUserByHighValue(User user) {
        if (user == null) {
            return 0;
        }

        int maxNumIndex = user.couponsList.size() - 1;
        int maxNumValue = 0;

        for (int i = 0; i < user.couponsList.size(); i++) {

            if (user.couponsList.get(i).getValue() > maxNumValue) {
                maxNumIndex = i;
                maxNumValue = user.couponsList.get(i).getValue();

            }
        }
        System.out.println(maxNumIndex);
        user.couponsList.remove(maxNumIndex);
        return maxNumValue;


    }

    public int useCouponForUserByCloseDate(User user) {
        if (user == null) {
            return 0;
        }

        int closeDateIndex = 0;
        int closeDateCouponValue = 0;
        LocalDate closeDate = user.couponsList.get(0).getDate();

        for (int i = 0; i < user.couponsList.size(); i++) {

            if (user.couponsList.get(i).getDate().compareTo(closeDate) == -1) {
                closeDateIndex = i;
                closeDateCouponValue = user.couponsList.get(i).getValue();
                closeDate = user.couponsList.get(i).getDate();

            }
        }
        System.out.println(closeDateIndex);
        user.couponsList.remove(closeDateIndex);
        return closeDateCouponValue;

    }

    public int useCouponForUserRandomly(User user) {
        if (user == null) {
            return 0;
        }
        int randomIndex = (int) (Math.random() * (user.couponsList.size() - 1));
        int coupounValue = user.couponsList.get(randomIndex).getValue();

        user.couponsList.remove(randomIndex);
        return coupounValue;
    }
}
