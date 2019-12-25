package org.sse.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sse.userservice.model.Result;
import org.sse.userservice.model.User;
import org.sse.userservice.service.UserService;

/**
 * @author cbc
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public Result login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping(value = "/register")
    public Result createNewUser(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping(value = "/user/info/{username}")
    public User getUserInfoWithoutPassword(@PathVariable String username) {
        return userService.getUserInfoWithoutPassword(username);
    }

}
