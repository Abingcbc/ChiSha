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
     * @param email user's email
     * @return user auth info
     */
    @Select("select * from user where email = #{email}")
    User getUserByEmail(@Param("email") String email);

    /**
     * create new user
     * @param user Object of user
     * @return number of affected rows
     */
    @Insert("INSERT INTO user(NICKNAME, PHONE, EMAIL, IS_AUTHORIZED, GENDER, PASSWORD, BORN_PLACE, AGE) \n" +
            "VALUES (#{nickname}, #{phone}, #{email}, #{isAuthorized}, #{gender}, #{password}, #{age});")
    int createNewUser(@Param("user") User user);

}
