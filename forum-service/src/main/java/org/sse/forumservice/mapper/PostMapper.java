package org.sse.forumservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
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
            "    post\n" +
            "WHERE\n" +
            "    is_delete = 0\n" +
            "ORDER BY post_id DESC")
    List<Post> getPostOrderByTime();

    /**
     * search post by keyword order by time
     * @param keyword keyword
     * @return list of result
     */
    @Select("SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    post\n" +
            "WHERE\n" +
            "    title LIKE '%c%' AND is_delete = 0\n" +
            "ORDER BY post_id DESC")
    List<Post> searchPostOrderByTime(@Param("keyword") String keyword);

    /**
     * get post by id
     * @param id post id
     * @return post
     */
    @Select("SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    post\n" +
            "WHERE\n" +
            "    post_id = #{id} and is_delete = 0")
    Post getPostById(@Param("id") long id);


}
