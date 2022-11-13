package StartAtGoogle.AuthenticationProjectSpringBoot.Controllers;

import StartAtGoogle.AuthenticationProjectSpringBoot.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.regex.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private AuthenticationService authenticationService;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z]).{8,20}$");
    private static final Pattern emailPattern = Pattern.compile(".+@.+\\.[a-z]+");


    public UserController() {

    }

    @RequestMapping(value = "/updateUserName", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUserName(@RequestParam String id, @RequestHeader String token, @RequestBody Map<String, Object> userName) {
        if (authenticateUser(id, token)) {
            userService.updateUserName(id, (String) userName.get("name"));
            return ResponseEntity.status(HttpStatus.OK).body("the name is updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The user was not authenticated");
    }

    @RequestMapping(value = "/updateUserEmail", method = RequestMethod.PUT)
    public ResponseEntity<String> updateEmail(@RequestParam String id, @RequestHeader String token, @RequestBody Map<String, Object> email) {
        if (authenticateUser(id, token)) {
            if (validateEmail((String) email.get("email"))) {
                userService.updateEmail(id, (String) email.get("email"));
                return ResponseEntity.status(HttpStatus.OK).body("Email is updated");

            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email inserted");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The user was not authenticated");
        }

    }

    @RequestMapping(value = "/updateUserPassword", method = RequestMethod.PUT)
    public ResponseEntity<String> updatePassword(@RequestParam String id, @RequestHeader String token, @RequestBody Map<String, Object> password) {
        if (authenticateUser(id, token)) {
            if (validatePassword((String) password.get("password"))) {
                userService.updatePassword(id, (String) password.get("password"));
                return ResponseEntity.status(HttpStatus.OK).body("Password is updated");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid password inserted");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The user was not authenticated");
        }

    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@RequestParam String id, @RequestHeader("token") String token) {
        if (authenticateUser(id, token)) {
            authenticationService.deleteUserFromMap(id);
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body("user is deleted");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The user was not authenticated");
        }
    }

    public boolean authenticateUser(String id, String token) {
        return authenticationService.authUser(id, token);
    }

    public boolean validateEmail(String email) {
        Matcher m = emailPattern.matcher(email);
        boolean matchFound = m.matches();
        if (matchFound) {
            if (userService.checkIfEmailExists(email)) {
                throw new IllegalArgumentException("You cant change the email to the same one");
            }
            return true;
        }
        return false;
    }

    public boolean validatePassword(String password) {
        Matcher m = PASSWORD_PATTERN.matcher(password);
        boolean matchFound = m.matches();
        if (matchFound) {
            return true;
        }
        return false;
    }


}