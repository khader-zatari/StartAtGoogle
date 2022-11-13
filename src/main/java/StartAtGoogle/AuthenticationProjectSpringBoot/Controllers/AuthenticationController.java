package StartAtGoogle.AuthenticationProjectSpringBoot.Controllers;

import StartAtGoogle.AuthenticationProjectSpringBoot.ParsingClasses.LoginUser;
import StartAtGoogle.AuthenticationProjectSpringBoot.Services.AuthenticationService;
import StartAtGoogle.AuthenticationProjectSpringBoot.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z]).{8,20}$");
    private static final Pattern emailPattern = Pattern.compile(".+@.+\\.[a-z]+");

    public AuthenticationController() {

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)//we should add header.
    public ResponseEntity<HashMap<String, String>> logIn(@RequestBody LoginUser user) {

        Matcher matchMail = emailPattern.matcher(user.getEmail());
        Matcher matchPassword = PASSWORD_PATTERN.matcher(user.getPassword());

        boolean emailMatchFound = matchMail.matches();
        boolean passwordMatchFound = matchPassword.matches();

        if (!emailMatchFound) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("write email properly example@ex.com");
        }
        if (!passwordMatchFound) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("password isn't proper password");
        }
        if (authenticationService.checkIfEmailExists(user.getEmail())) {
            try {
                return ResponseEntity.status(HttpStatus.OK).body(authenticationService.logIn(user.getEmail(), user.getPassword()));
            } catch (Exception e) {
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
                return null;
            }
        }
        HashMap<String, String> hash = new HashMap<>();
        hash.put("message", "user is not registered");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hash);


    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        Matcher matchMail = emailPattern.matcher(user.getEmail());
        Matcher matchPassword = PASSWORD_PATTERN.matcher(user.getPassword());

        boolean emailMatchFound = matchMail.matches();
        boolean passwordMatchFound = matchPassword.matches();

        if (!emailMatchFound) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong email");

        }
        if (!passwordMatchFound) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong password");
        }
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.createUser(user.getName(), user.getEmail(), user.getPassword()));

    }

    public boolean authUser(String id, String token) {
        if (token.length() != 18) {
            throw new IllegalArgumentException("the token is not valid");
        }
        return authenticationService.authUser(id, token);
    }
}
