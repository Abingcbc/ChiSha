package org.sse.userservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sse.userservice.mapper.UserMapper;
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

    public int register(String username, String password, String email, String avatarUrl) {
        if (userMapper.getUserByUsername(username) != null) {
            return 0;
        } else {
            password = passwordEncoder.encode(password);
            if (avatarUrl == null) {
                avatarUrl = "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png";
            }
            if (userMapper.createNewUser(username, password, email, avatarUrl) == 1) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public User getUserInfoWithoutPassword(String username) {
        return userMapper.getUserByUsername(username);
    }

    /**
     * update user's information
     * @param username new username
     * @param oPassword origin password
     * @param password new password
     * @param email email
     * @param avatarUrl avatar url
     * @return -1: No such user
     *         -2: Update password failed
     *         -3: Origin password wrong
     *         -4: Update email failed
     *         -5: Update avatar failed
     *         1: success
     */
    public int updateInfo(String username,
                          String oPassword,
                          String password,
                          String email,
                          String avatarUrl) {
        if (userMapper.getUserByUsername(username) == null) {
            return -1;
        }
        // no password update
        if (oPassword != null) {
            if (userMapper.getUserByUsername(username).getPassword()
                    .equals(passwordEncoder.encode(oPassword))) {
                if (userMapper.updatePassword(username,
                        passwordEncoder.encode(password)) != 1) {
                    return -2;
                }
            } else {
                return -3;
            }
        }
        if (email != null) {
            if (userMapper.updateEmail(username, email) != 1) {
                return -4;
            }
        }
        if (avatarUrl != null) {
            if (userMapper.updateAvatar(username, avatarUrl) != 1) {
                return -5;
            }
        }
        return 1;
    }

}
