package controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user/add",consumes = "application/json")
    ResponseEntity<User> addUser(@RequestBody User user){
        Optional<User> user1 = Optional.of(userService.addUser(user));
        return ResponseEntity.of(user1);
    }

    @GetMapping("/user/login/all")
    List<User> getAllUsers(){
        return userService.findAll();
    }
}
