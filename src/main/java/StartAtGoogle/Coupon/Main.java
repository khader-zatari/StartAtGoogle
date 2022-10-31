package StartAtGoogle.Coupon;

public class Main {
    // user should show the list to the store.
    // the store and the user used by the client.
    public static void main(String[] args) {
        // i shouldnot make coupon.genertaterandomCoupon() to the user here, it should be in the store.
        Store store = new Store("My Store");
        User user = new User("Khader");

        store.assignCouponToUser(Coupon.generateRandomCoupon(), user);
        store.assignCouponToUser(Coupon.generateRandomCoupon(), user);
        store.assignCouponToUser(Coupon.generateRandomCoupon(), user);
        System.out.println(user.couponsList);
//        int couponeValueForUserById = store.useCouponForUserById(user.couponsList.get(0).getId(), user);
//        System.out.println(couponeValueForUserById);
//        int couponeValueForUserByHightValue = store.useCouponForUserByHighValue(user);
//        System.out.println(couponeValueForUserByHightValue);
        int useCouponForUserByCloseDate = store.useCouponForUserByCloseDate(user);
        System.out.println(useCouponForUserByCloseDate);
//        int useCouponForUserRandom = store.useCouponForUserRandomly(user);
//        System.out.println(user);


//        System.out.println(useCouponForUserRandom);
        System.out.println(user.couponsList);
    }


}

