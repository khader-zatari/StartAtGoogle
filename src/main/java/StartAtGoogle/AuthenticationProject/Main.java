package StartAtGoogle.AuthenticationProject;

import StartAtGoogle.AuthenticationProject.Controllers.AuthenticationController;
import StartAtGoogle.AuthenticationProject.Controllers.UserController;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        UserController userController = UserController.getInstance();
        AuthenticationController authenticationController = AuthenticationController.getInstance();


        authenticationController.createUser("Leon Shapiroff", "new@gmail.com", "leon123433");
        authenticationController.logIn("haitham@gmail.com" , "leon123433");
        Tests.testUpdateEmail();
        Tests.testUpdatePassword();
        Tests.testDeleteUser();

    }
}