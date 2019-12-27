package org.sse.forumservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author HPY
 */
@Component
@Mapper
public interface PostMapper {
    @Select("SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    post\n" +
            "ORDER BY post_id DESC")
    List<Post>
}
