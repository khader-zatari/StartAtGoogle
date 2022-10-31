package StartAtGoogle.Basics;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class User {
    public static void main(String[] args) {
        User user = new User(
                random_name(4)
                , random_id()
                , random_isActivated()
        );
        System.out.println(user);
    }

    String name;
    String id;
    Boolean isActivated;

    public User(String name, String id, Boolean isActivated) {
        this.name = name;
        this.id = id;
        this.isActivated = isActivated;
    }

    public static HashMap<String, User> createRandomUsers(int numberOfUsers) {

        HashMap<String, User> usersHashMap = new HashMap<String, User>();

        for (int i = 0; i < numberOfUsers; i++) {
            String userRandomId = User.random_id();
            usersHashMap.put(userRandomId, new User(random_name(4), userRandomId, random_isActivated()));
        }

        return usersHashMap;

    }
    public static String random_name(int len) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static String random_id() {
        return UUID.randomUUID().toString();
    }

    public static Boolean random_isActivated() {
        return Math.random() < 0.5;
    }



    @Override
    public String toString() {
        return "name is" + this.name + " id is " + this.id + " isActivated " + this.isActivated;
    }
}
