package org.sse.userservice.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.sse.userservice.dto.UserShow;
import org.sse.userservice.model.User;

import java.util.List;

/**
 * @author cbc
 */
@Component
@Mapper
public interface UserMapper {

    /**
     * get user auth info by phone when login
     * @param phone user's phone
     * @return user auth info
     */
    @Select("select * from user where phone = #{phone};")
    User getUserByPhone(@Param("phone") String phone);


    /**
     * get user info by id
     * @param id user's phone
     * @return user auth info
     */
    @Select("select user_id, nickname, phone, email, is_authorized, gender,\n" +
            "       p.province_name as born_place, age\n" +
            "from user\n" +
            "left join province p on user.born_place = p.province_id\n" +
            "where user_id = #{id};")
    UserShow getUserById(@Param("id") Long id);

    /**
     * create new user
     * @param user Object of user
     * @return number of affected rows
     */
    @Insert("INSERT INTO user(NICKNAME, PHONE, EMAIL, IS_AUTHORIZED, GENDER, PASSWORD, BORN_PLACE, AGE) \n" +
            "VALUES (#{nickname}, #{phone}, #{email}, #{isAuthorized}, #{gender}, " +
            "#{password}, #{bornPlace}, #{age});")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int createNewUser(User user);

    /**
     *
     * @param userId
     * @param styleList
     * @return
     */
    @Insert({"<script>"
            + "insert into user_prefer_style values"
            + "<foreach collection='styleList' item='item' index='index' separator=','>"
            + "(#{userId}, ${item}, 1)"
            + "</foreach>"
            + "</script>"
    })
    int createNewUserStyle(@Param("userId") Long userId,
                           @Param("styleList")List<Long> styleList);

    /**
     *
     * @param userId
     * @param tasteList
     * @return
     */
    @Insert({"<script>"
            + "insert into user_prefer_taste values"
            + "<foreach collection='tasteList' item='item' index='index' separator=','>"
            + "(#{userId}, ${item}, 1)"
            + "</foreach>"
            + "</script>"
    })
    int createNewUserTaste(@Param("userId") Long userId,
                           @Param("tasteList")List<Long> tasteList);

}
