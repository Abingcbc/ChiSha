package org.sse.userservice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sse.userservice.dto.UserShow;
import org.sse.userservice.model.Result;
import org.sse.userservice.model.User;
import org.sse.userservice.service.UserService;

import java.util.List;

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
    public Result createNewUser(@RequestBody JSONObject jsonObject) {
        User user = jsonObject.getObject("userinformation", User.class);
        List<Long> styleList = JSONObject.parseArray(jsonObject.
                getJSONArray("type").toJSONString(), Long.class);
        List<Long> tasteList = JSONObject.parseArray(jsonObject.
                getJSONArray("taste").toJSONString(), Long.class);
        return userService.register(user, styleList, tasteList);
    }

    @GetMapping(value = "/user/info/{id}")
    public UserShow getUserInfoWithoutPassword(@PathVariable Long id) {
        return userService.getUserInfoWithoutPassword(id);
    }

}
