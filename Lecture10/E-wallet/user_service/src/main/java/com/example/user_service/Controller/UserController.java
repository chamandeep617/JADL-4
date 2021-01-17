package com.example.user_service.Controller;

import com.example.user_service.Exception.UserNotFoundException;
import com.example.user_service.Model.User;
import com.example.user_service.Repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserController {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    private UserRepository repository;
    // Find
    @ApiOperation(value = "Find all the User")
    @GetMapping("/users")
    List<User> findAll() {
        return repository.findAll();
    }

    @ApiOperation(value = "Register New User")
    @PostMapping("/users")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Find a given user
    @ApiOperation(value = "Find User by Id ")
    @GetMapping("/users/{id}")
    User findOne(@PathVariable int id) {
        LOGGER.info("/users/{id} called with id "+ id);
        // Optional<User> user = repository.findById(id);
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

}
