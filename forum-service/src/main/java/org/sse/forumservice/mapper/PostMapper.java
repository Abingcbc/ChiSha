package org.sse.forumservice.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.sse.forumservice.dto.PostDTO;
import org.sse.forumservice.model.Post;

import java.util.List;

/**
 * @author HPY
 */
@Component
@Mapper
public interface PostMapper {

    /**
     * get post order by time
     * @return list of post
     */
    @Select("SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    what_to_eat.post\n" +
            "        JOIN\n" +
            "    user ON post.user_id = user.user_id\n" +
            "WHERE\n" +
            "    is_delete = 0\n" +
            "ORDER BY post_id DESC")
    List<PostDTO> getPostOrderByTime();

    /**
     * search post by keyword order by time
     * @param keyword keyword
     * @return list of result
     */
    @Select("SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    post\n" +
            "        JOIN\n" +
            "    user ON post.user_id = user.user_id\n" +
            "WHERE\n" +
            "    title LIKE #{keyword} AND is_delete = 0\n" +
            "ORDER BY post_id DESC")
    List<PostDTO> searchPostOrderByTime(@Param("keyword") String keyword);

    /**
     * get post by id
     * @param id post id
     * @return post
     */
    @Select("SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    post\n" +
            "        JOIN\n" +
            "    user ON post.user_id = user.user_id\n" +
            "WHERE\n" +
            "    post_id = #{id} and is_delete = 0")
    PostDTO getPostById(@Param("id") long id);


    /**
     * publish post
     * @param post post
     */
    @Insert("insert into post (title,content,like_num,comment_num,is_delete,contact,post_image,create_time,user_id)\n" +
            "values (#{title},#{content},0,0,0,#{contact},#{postImage},now(),#{userId});")
    @Options(useGeneratedKeys = true, keyProperty = "postId",keyColumn = "post_id")
    void insertPost(Post post);

    /**
     * add like num
     * @param id post id
     */
    @Update("UPDATE post \n" +
            "SET \n" +
            "    like_num = like_num + 1\n" +
            "WHERE\n" +
            "    post_id = #{id};")
    void addPostLikeNum(@Param("id") long id);

    /**
     * minus like num
     * @param id post id
     */
    @Update("UPDATE post \n" +
            "SET \n" +
            "    like_num = like_num - 1\n" +
            "WHERE\n" +
            "    post_id = #{id};")
    void minusPostLikeNum(@Param("id") long id);
}
