package StartAtGoogle.Basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ////////////////////

//        int[] numbers = {1, 2, 3, 4, 5, 6 };
//        int x = 2;
//        numbersThatDivededByX(numbers, x);

        ////////////////////

        HashMap<String, User> userHashMap = User.createRandomUsers(4);
        printHashMap(userHashMap);

//        System.out.println(countActivatedUsers(userHashMap));

//      ///////////////////////
//
        System.out.println();
        List<User> listofvalues = new ArrayList<User>(userHashMap.values());
        System.out.println(getUserById(listofvalues, listofvalues.get(1).id));
        ///////////////////////


    }

    public static void numbersThatDivededByX(int[] numbers, int x) {

        for (int num : numbers) {
            if (num % x == 0) {
                System.out.println(num);
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % x == 0) {
                System.out.println(numbers[i]);
            }

        }

        int i = 0;
        while (i < numbers.length) {
            if (numbers[i] % x == 0) {
                System.out.println(numbers[i]);
            }
            i++;
        }
    }

    public static int countActivatedUsers(HashMap<String, User> hash) {
        int userCounter = 0;
        for (User user : hash.values()) {
            if (user.isActivated) {
                userCounter++;
            }
        }
        return userCounter;

    }

    public static User getUserById(List<User> listofvalues, String id) {
        for (User user : listofvalues) {
            if (user.id == id) {
                return user;
            }
        }
        return null;
    }

    public static void printHashMap(HashMap<String, User> usersHashMap) {
        for (User user : usersHashMap.values()) {
            System.out.println(user);
        }
    }
}