package StartAtGoogle.AuthenticationProjectSpringBoot.Services;

import StartAtGoogle.AuthenticationProjectSpringBoot.User;
import StartAtGoogle.AuthenticationProjectSpringBoot.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AuthenticationService {
    @Autowired
    private  UserRepository userRepository;

    public AuthenticationService() {

    }


    public static HashMap<String, String> userTokens = new HashMap<>();



    public User createUser(String name, String email, String password) {
        if (userRepository.checkIfEmailExists(email)) {
            throw new IllegalArgumentException("the user has already registered");
        }
        User user = new User(name, email, password);
        userRepository.createUser(user);
        return user;
    }

    public HashMap<String, String> logIn(String email, String password) {

        String id;
        if (userRepository.checkIfUserExists(email, password)) {
            id = userRepository.getIdByEmail(email);
        } else {
            System.out.println("iam here");
            throw new IllegalArgumentException("the user is not valid");
        }
        if (userTokens.containsKey(id)) {
            throw new IllegalArgumentException("the user is logged in ");
        }

        String token = createToken();
        userTokens.put(id, token);
        HashMap<String, String> res = new HashMap<>();
        res.put(id, token);

        return res;
    }

    public boolean authUser(String id, String token) {
        for (HashMap.Entry<String, String> entry : userTokens.entrySet()) {
            if (entry.getKey().equals(id)) {
                return entry.getValue().equals(token);
            }
        }
        return false;
    }


    public void deleteUserFromMap(String id) {
        userTokens.remove(id);
    }

    private static String getSaltString(int stringLength) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        while (salt.length() < stringLength) {
            int index = (int) (ThreadLocalRandom.current().nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }

        return salt.toString();

    }

    public boolean checkIfEmailExists(String email) {
        return userRepository.checkIfEmailExists(email);
    }

    public static String createToken() {
        return getSaltString(18);
    }

}
