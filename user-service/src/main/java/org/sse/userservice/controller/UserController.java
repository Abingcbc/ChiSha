package org.sse.userservice.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sse.userservice.model.Result;
import org.sse.userservice.model.User;
import org.sse.userservice.service.UserService;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public void createNewUser(@RequestBody User user,
                              HttpServletResponse response) {
        int status = userService.register(user.getUsername(),
                user.getPassword(), user.getEmail(), user.getAvatarUrl());
        if (status == -1) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } else if (status == 0){
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    @GetMapping(value = "/user/info/{username}")
    public User getUserInfoWithoutPassword(@PathVariable String username) {
        return userService.getUserInfoWithoutPassword(username);
    }

    @PostMapping(value = "/user/update")
    public Result updateUserInfo(@RequestBody JSONObject jsonObject) {
        int status = userService.updateInfo(jsonObject.getString("username"),
                jsonObject.getString("oPassword"),
                jsonObject.getString("password"),
                jsonObject.getString("email"),
                jsonObject.getString("avatarUrl"));
        Result result = new Result();
        switch (status) {
            case 1:
                result.setMsg("success");
                break;
            case -1:
                result.setMsg("No such user");
                break;
            case -2:
                result.setMsg("Update password failed");
                break;
            case -3:
                result.setMsg("Origin password wrong");
                break;
            case -4:
                result.setMsg("Update email failed");
                break;
            case -5:
                result.setMsg("Update avatar failed");
                break;
            default:
                result.setMsg("Unknown error");
                break;
        }
        return result;
    }

    @GetMapping(value = "/avatar/{username}")
    public String getUserAvatarUrlByUsername(@PathVariable("username") String username) {
        return userService.getUserInfoWithoutPassword(username).getAvatarUrl();
    }
}
