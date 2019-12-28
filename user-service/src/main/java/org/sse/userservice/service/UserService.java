package org.sse.userservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.sse.userservice.mapper.UserMapper;
import org.sse.userservice.model.Result;
import org.sse.userservice.model.User;

import java.io.IOException;
import java.util.List;

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
        User userDB = userMapper.getUserByPhone(user.getPhone());
        if ( userDB == null) {
            return new Result(0, "No such user");
        }
        if (userDB.getPassword() != passwordEncoder.encode(user.getPassword())) {
            return new Result(0, "Wrong password");
        } else {
            return new Result(1, "Success");
        }
    }

    public Result register(User user, List<Long> styleList, List<Long> tasteList) {
        if (userMapper.getUserByPhone(user.getPhone()) != null) {
            return new Result(0, "Phone registered");
        } else {
            try {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                if (userMapper.createNewUser(user) != 1) {
                    throw new IOException();
                }
                if (userMapper.createNewUserStyle(user.getUserId(), styleList) != 1) {
                    throw new IOException();
                }
                if (userMapper.createNewUserTaste(user.getUserId(), tasteList) != 1) {
                    throw new IOException();
                }
                return new Result(1, "Success");
            } catch (Exception e) {
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return new Result(0, "Register fail");
            }
        }
    }

    public User getUserInfoWithoutPassword(String username) {
        User user = userMapper.getUserByPhone(username);
        user.setPassword(null);
        return user;
    }

}
