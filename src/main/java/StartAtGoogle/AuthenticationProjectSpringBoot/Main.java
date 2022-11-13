package StartAtGoogle.AuthenticationProjectSpringBoot;

import StartAtGoogle.AuthenticationProjectSpringBoot.Controllers.AuthenticationController;
import StartAtGoogle.AuthenticationProjectSpringBoot.Controllers.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}