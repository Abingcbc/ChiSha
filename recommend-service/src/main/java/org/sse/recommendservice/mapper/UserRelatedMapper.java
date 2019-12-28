package org.sse.recommendservice.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.sse.recommendservice.dto.BrowsingPlus;
import org.sse.recommendservice.dto.QueryResult;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author cbc
 */
@Component
@Mapper
public interface UserRelatedMapper {

    /**
     * get recent 1000 browsing history
     * @param limitNum number of return history
     * @return object of browsing history with user information
     */
    @Select("with recent_browsing as (select * from browsing_history\n" +
            "order by browse_time desc limit #{num})\n" +
            "select user_id, gender, age, born_place, recipe_id\n" +
            "from recent_browsing\n" +
            "left join user using (user_id);")
    List<BrowsingPlus> getRecentBrowsingHistory(@Param("num") int limitNum);

    /**
     *
     * @param idList
     * @return
     */
    @MapKey("id")
    @Select({
            "<script>" +
                    "select user_id as id, GROUP_CONCAT(style_id ORDER BY style_id SEPARATOR '|') as value\n" +
                    "from user_prefer_style\n" +
                    "where user_id in \n" +
                    "<foreach item = 'item' index = 'index' collection = 'idList' open='(' separator=',' close=')'>" +
                    "${item}" +
                    "</foreach>" +
                    " and is_prefer = 1 " +
                    "group by user_id;" +
                    "</script>"
    })
    Map<Long, QueryResult> getUserPreferStyleBatch(@Param("idList") Set<Long> idList);

    /**
     *
     * @param idList
     * @return
     */
    @MapKey("id")
    @Select({
            "<script>" +
                    "select user_id as id, GROUP_CONCAT(taste_id ORDER BY taste_id SEPARATOR '|') as value\n" +
                    "from user_prefer_taste\n" +
                    "where user_id in \n" +
                    "<foreach item = 'item' index = 'index' collection = 'idList' open='(' separator=',' close=')'>" +
                    "${item}" +
                    "</foreach>" +
                    " and is_prefer = 1 " +
                    "group by user_id;" +
                    "</script>"
    })
    Map<Long, QueryResult> getUserPreferTasteBatch(@Param("idList") Set<Long> idList);

    /**
     *
     * @param idList
     * @return
     */
    @MapKey("id")
    @Select({
            "<script>" +
                    "select user_id as id, substring_index(GROUP_CONCAT(recipe_id ORDER BY browse_time desc SEPARATOR '|'), '|', 20)" +
                    " as value\n" +
                    "from browsing_history\n" +
                    "where user_id in \n" +
                    "<foreach item = 'item' index = 'index' collection = 'idList' open='(' separator=',' close=')'>" +
                    "${item}" +
                    "</foreach>" +
                    "group by user_id;" +
                    "</script>"
    })
    Map<Long, QueryResult> getUserBrowsingBatch(@Param("idList") Set<Long> idList);

}
