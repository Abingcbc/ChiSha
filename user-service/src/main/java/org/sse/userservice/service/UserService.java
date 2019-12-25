package org.sse.userservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sse.userservice.mapper.UserMapper;
import org.sse.userservice.model.Result;
import org.sse.userservice.model.User;

/**
 * @author cbc
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    UserMapper userMapper;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Result login(User user) {
        User userDB = userMapper.getUserByEmail(user.getPhone());
        if ( userDB == null) {
            return new Result(0, "No such user");
        }
        if (userDB.getPassword() != passwordEncoder.encode(user.getPassword())) {
            return new Result(0, "Wrong password");
        } else {
            return new Result(1, "Success");
        }
    }

    public Result register(User user) {
        if (userMapper.getUserByEmail(user.getPhone()) != null) {
            return new Result(0, "Phone registered");
        } else {
            String password = passwordEncoder.encode(user.getPassword());
            if (userMapper.createNewUser(user) == 1) {
                return new Result(1, "Success");
            } else {
                return new Result(0, "Register fail");
            }
        }
    }

    public User getUserInfoWithoutPassword(String username) {
        User user = userMapper.getUserByEmail(username);
        user.setPassword(null);
        return user;
    }

}
