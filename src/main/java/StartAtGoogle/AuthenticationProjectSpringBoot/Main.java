package StartAtGoogle.AuthenticationProjectSpringBoot;

import StartAtGoogle.AuthenticationProjectSpringBoot.Controllers.AuthenticationController;
import StartAtGoogle.AuthenticationProjectSpringBoot.Controllers.UserController;

public class Main {
    public static void main(String[] args) {

        UserController userController = UserController.getInstance();
        AuthenticationController authenticationController = AuthenticationController.getInstance();


        //authenticationController.createUser("Leon Shapiro", "leon@email.com", "leon1234");
        //Tests.testUpdateEmail();
        //Tests.testUpdatePassword();
        //Tests.testDeleteUser();

    }
}