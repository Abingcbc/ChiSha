package org.sse.userservice.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.sse.userservice.model.User;

/**
 * @author cbc
 */
@Component
@Mapper
public interface UserMapper {

    /**
     * get user auth info by username when login
     * @param username user's name
     * @return user auth info
     */
    @Select("select * from user where username = #{username}")
    User getUserByUsername(@Param("username") String username);

    /**
     * create new user
     * @param username username
     * @param password password
     * @param email email
     * @param avatarUrl avatar url
     * @return number of affected rows
     */
    @Insert("insert into user(username, password, email, avatar_url, like_num)" +
            " values(#{username}, #{password}, #{email}, #{avatarUrl}, 0);")
    int createNewUser(@Param("username") String username,
                      @Param("password") String password,
                      @Param("email") String email,
                      @Param("avatarUrl") String avatarUrl);

    /**
     * update user's password
     * @param username username
     * @param password new password
     * @return number of affected rows
     */
    @Update("update user\n" +
            "set password = #{password}, email = #{email}\n" +
            "where username = #{username}\n")
    int updatePassword(@Param("username") String username,
                       @Param("password") String password);

    /**
     * update user's Email
     * @param username username
     * @param email new email
     * @return number of affected rows
     */
    @Update("update user\n" +
            "set email = #{email}\n" +
            "where username = #{username}\n")
    int updateEmail(@Param("username") String username,
                    @Param("email") String email);

    /**
     * update user's avatar
     * @param username username
     * @param avatarUrl new avatar url
     * @return number of affected rows
     */
    @Update("update user\n" +
            "set avatar_url = #{avatarUrl}\n" +
            "where username = #{username}\n")
    int updateAvatar(@Param("username") String username,
                     @Param("avatarUrl") String avatarUrl);
}
