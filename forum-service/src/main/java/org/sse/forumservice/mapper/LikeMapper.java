package org.sse.forumservice.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.sse.forumservice.model.UserLikePost;

/**
 * @author HPY
 */
@Mapper
@Component
public interface LikeMapper {

    /**
     * get like by user and post
     * @param userId
     * @param postId
     * @return
     */
    @Select("SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    user_like_post\n" +
            "WHERE\n" +
            "    user_id = #{userId} AND post_id = #{postId};")
    UserLikePost getLikeByUserAndPost(@Param("userId") long userId,
                                      @Param("postId") long postId);

    /**
     * insert like
     * @param userId user id
     * @param postId post id
     * @return is inserted
     */
    @Insert("insert user_like_post(user_id,post_id,is_like) value(#{userId},#{postId},1)")
    boolean insertLike(@Param("userId") long userId,
                       @Param("postId") long postId);

    /**
     * set is_like
     * @param userId user id
     * @param postId post id
     * @param isLike is_like
     * @return is set
     */
    @Update("UPDATE user_like_post \n" +
            "SET \n" +
            "    is_like = #{isLike}\n" +
            "WHERE\n" +
            "    user_id = #{userId} AND post_id = #{postId}")
    boolean setIsLike(@Param("userId") long userId,
                      @Param("postId") long postId,
                      @Param("isLike") long isLike);

}
