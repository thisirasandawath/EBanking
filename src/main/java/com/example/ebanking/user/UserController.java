package com.example.ebanking.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin()
    @PostMapping("/register")
    public Status registerUser(@Valid @RequestBody User newUser) {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            if (user.equals(newUser)) {
                log.info("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }

        userRepository.save(newUser);
        return Status.SUCCESS;
    }

//    @CrossOrigin()
//    @PostMapping("/login")
//    public Status loginUser(@Valid @RequestBody User user) {
//        List<User> users = userRepository.findAll();
//
//        for (User other : users) {
//            if (other.equals(user)) {
//                user.setLoggedIn(true);
//                userRepository.save(user);
//                return Status.SUCCESS;
//            }
//        }
//
//        return Status.FAILURE;
//    }

    //NOT WORKING
    @CrossOrigin()
    @PostMapping ("/login")
    public Status authenticateUser(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.getId()==(user.getId()) && other.getUsername().equals(user.getUsername()) && other.getPassword().equals(user.getPassword())) {
                user.setLoggedIn(true);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }

        return Status.PLEASE_CHECK_YOUR_CREDENTIALS;
    }

    @CrossOrigin()
    @GetMapping("/all")
    public List<User> listAllUsers() {

            return userRepository.findAll();
    }

    @GetMapping("getUserById/{id}")
    public User getUserById(@PathVariable String id){

        return userRepository.getUserById(id);

    }

    @CrossOrigin
    @PutMapping("/update")
    public Status updateUsers(@Valid @RequestBody User user){

        if(user.isLoggedIn()){
            userRepository.save(user);
            return Status.SUCCESS;
        }else {
            return Status.FAILURE;
        }
    }

    @CrossOrigin()
    @DeleteMapping("/delete")
    public Status deleteUsers(@Valid @RequestBody User user) {

        userRepository.delete(user);
        return Status.SUCCESS;
    }

    //NOT WORKING
    @CrossOrigin()
    @DeleteMapping ("deleteUserById/{id}")
    public User deleteUserById(@PathVariable String id){

        return userRepository.deleteUserById(id);

    }

    //NOT WORKING
    @CrossOrigin()
    @PostMapping("/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();

        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }

        return Status.FAILURE;
    }
}
