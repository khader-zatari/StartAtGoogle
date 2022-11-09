package StartAtGoogle.AuthenticationProjectLogger.UserRepository;

import StartAtGoogle.AuthenticationProjectLogger.User;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;


public class UserRepository {
    //    private static final String path = "src/main/java/AuthenticationProject/UserRepository/users/";
    private static Logger logger = LogManager.getLogger(UserRepository.class.getName());
    private static final String path = "/Users/khaderzatari/Desktop/StartAtGoogle/src/main/java/StartAtGoogle/AuthenticationProject/UserRepository/users/";
    //    private static final String path = "../AuthenticationProject/src/main/java/AuthenticationProject/UserRepository/users/";
    private static final Gson gson = new Gson();
    private static UserRepository userRepository;

    private UserRepository() {
    }

    public static synchronized UserRepository getInstance() {
        if (userRepository == null) {
            logger.info("user repository instance is created");
            userRepository = new UserRepository();
        }
        logger.info("user repository instance is returned");
        return userRepository;
    }

    private User fetchUser(String filePath) {
        logger.info("start fetchUser function");
        JsonReader reader = null;
        User data = null;
        Type USER_TYPE = User.class;
        try {
            reader = new JsonReader(new FileReader(filePath));
            data = gson.fromJson(reader, USER_TYPE); // contains the whole users list
            reader.close();
            if (data == null) {
                logger.error("user not found");
                throw new RuntimeException("user not found");
            }
        } catch (IOException e) {
            logger.error("user's file not found");
            throw new RuntimeException("user's file not found");
        }
        logger.info("data is returned");
        return data;
    }


    public void createUser(User user) {
        logger.info("start createUser function");
        PrintWriter writer = null;
        String usersJson = gson.toJson(user);
        System.out.println(usersJson);
        try {
            File file = new File(path);
            writer = new PrintWriter(path + user.getId() + ".json", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            logger.error("failed to create user");
            throw new RuntimeException("failed to create user");
        }
        writer.print(usersJson);
        writer.close();
        logger.warn("file is closed");
    }


    public boolean checkIfEmailExists(String email) {
        logger.info("start checkIfEmailExists function");
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (fetchUser(file.getPath()).getEmail().equals(email)) {
                logger.info("email does exist");
                return true;
            }
        }
        logger.info("email doesn't exist");
        return false;
    }

    public boolean checkIfUserExists(String email, String password) {
        logger.info("start checkIfUserExists function");
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (fetchUser(file.getPath()).getEmail().equals(email) && fetchUser(file.getPath()).getPassword().equals(password)) {
                    logger.info("user does exist");
                    return true;
                }
            }
        }
        logger.info("user doesn't exist");
        return false;
    }

    public String getIdByEmail(String email) {
        logger.info("start GetIdByEmail function");
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            User user = fetchUser(file.getPath());
            if (user.getEmail().equals(email)) {
                logger.info("user id found");
                return user.getId();
            }
        }
        logger.error("user not found");
        throw new IllegalArgumentException("user not found");
    }

    public void updateEmail(String id, String email) {
        logger.info("start updateEmail function");
        User user = fetchUser(path + id + ".json");
        user.setEmail(email);
        PrintWriter writer = null;
        String usersJson = gson.toJson(user);
        try {
            writer = new PrintWriter(path + id + ".json", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            logger.error("failed to update user");
            throw new RuntimeException("failed to update user");
        }
        writer.print(usersJson);
        writer.close();
        logger.info("file closed");
    }

    public void updateName(String id, String name) {
        logger.info("start updateName function");
        User user = fetchUser(path + id + ".json");
        user.setName(name);
        PrintWriter writer = null;
        String usersJson = gson.toJson(user);
        try {
            writer = new PrintWriter(path + id + ".json", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            logger.error("failed to update user");
            throw new RuntimeException("failed to update user");
        }
        writer.print(usersJson);
        writer.close();
        logger.warn("file is closed");
    }

    public void updatePassword(String id, String password) {
        logger.info("start updatePassword function");
        User user = fetchUser(path + id + ".json");
        user.setPassword(password);
        PrintWriter writer = null;
        String usersJson = gson.toJson(user);
        try {
            writer = new PrintWriter(path + id + ".json", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            logger.error("failed to update user");
            throw new RuntimeException("failed to update user");
        }
        writer.print(usersJson);
        writer.close();
        logger.warn("file closed");
    }

    public void deleteUser(String id) {
        logger.info("start deleteUser function");
        try {
            Files.delete(Paths.get(path + id + ".json"));
        } catch (IOException e) {
            logger.error("failed to delete user");
            throw new RuntimeException("failed to delete user");
        }

    }


}
