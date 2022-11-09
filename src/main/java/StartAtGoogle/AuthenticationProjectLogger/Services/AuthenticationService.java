package StartAtGoogle.AuthenticationProjectLogger.Services;

import StartAtGoogle.AuthenticationProjectLogger.User;
import StartAtGoogle.AuthenticationProjectLogger.UserRepository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class AuthenticationService {
    private static Logger logger = LogManager.getLogger(AuthenticationService.class.getName());
    private static AuthenticationService authenticationService;
    private static UserRepository userRepository;

    private AuthenticationService() {
        userRepository = UserRepository.getInstance();
    }

    public static synchronized AuthenticationService getInstance() {
        if (authenticationService == null) {
            authenticationService = new AuthenticationService();
        }
        return authenticationService;
    }

    public static HashMap<String, String> userTokens = new HashMap<>();


    public void createUser(String name, String email, String password) {
        logger.info("start createUser function");
        if (userRepository.checkIfEmailExists(email)) {
            logger.error("the user has already registered");
            throw new IllegalArgumentException("the user has already registered");
        }
        User user = new User(name, email, password);
        userRepository.createUser(user);
    }

    public HashMap<String, String> logIn(String email, String password) {
        logger.info("start logIn function");
        String id;
        if (userRepository.checkIfUserExists(email, password)) {
            id = userRepository.getIdByEmail(email);
        } else {
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
        logger.info("start authUser function");
        for (HashMap.Entry<String, String> entry : userTokens.entrySet()) {
            if (entry.getKey().equals(id)) {
                return entry.getValue().equals(token);
            }
        }
        return false;
    }


    public void deleteUserFromMap(String id) {
        logger.info("start deleteUserFromMap function");
        userTokens.remove(id);
    }

    private static String getSaltString(int stringLength) {
        logger.info("start getSaltString function");
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        while (salt.length() < stringLength) {
            int index = (int) (ThreadLocalRandom.current().nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }

        return salt.toString();

    }

    public boolean checkIfEmailExists(String email) {
        logger.info("start checkIfEmailExists function");

        return userRepository.checkIfEmailExists(email);
    }

    public static String createToken() {
        return getSaltString(18);
    }

}
