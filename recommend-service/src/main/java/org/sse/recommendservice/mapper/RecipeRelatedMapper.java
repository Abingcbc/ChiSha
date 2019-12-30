package org.sse.recommendservice.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.sse.recommendservice.dto.QueryResult;
import org.sse.recommendservice.dto.RecommendRecipe;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author cbc
 */
@Component
@Mapper
public interface RecipeRelatedMapper {


    /**
     *
     * @param idList
     * @return
     */
    @MapKey("id")
    @Select({
            "<script>" +
                    "select recipe_id as id, GROUP_CONCAT(taste_id ORDER BY taste_id SEPARATOR '|') as value\n" +
                    "from recipe_has_taste\n" +
                    "where recipe_id in \n" +
                    "<foreach item = 'item' index = 'index' collection = 'idList' open='(' separator=',' close=')'>" +
                    "${item}" +
                    "</foreach>" +
                    "group by recipe_id;" +
                    "</script>"
    })
    Map<Long, QueryResult> getRecipeTasteBatch(@Param("idList") Set<Long> idList);

    /**
     *
     * @param idList
     * @return
     */
    @MapKey("id")
    @Select({
            "<script>" +
                    "select recipe_id as id, GROUP_CONCAT(style_id ORDER BY style_id SEPARATOR '|') as value\n" +
                    "from recipe_has_style\n" +
                    "where recipe_id in \n" +
                    "<foreach item = 'item' index = 'index' collection = 'idList' open='(' separator=',' close=')'>" +
                    "${item}" +
                    "</foreach>" +
                    "group by recipe_id;" +
                    "</script>"
    })
    Map<Long, QueryResult> getRecipeStyleBatch(@Param("idList") Set<Long> idList);

    /**
     *
     * @param idList
     * @return
     */
    @MapKey("id")
    @Select({
            "<script>" +
                    "select recipe_id as id, GROUP_CONCAT(ingredient_id ORDER BY ingredient_id SEPARATOR '|') as value\n" +
                    "from recipe_has_ingredient\n" +
                    "where recipe_id in \n" +
                    "<foreach item = 'item' index = 'index' collection = 'idList' open='(' separator=',' close=')'>" +
                    "${item}" +
                    "</foreach>" +
                    "group by recipe_id;" +
                    "</script>"
    })
    Map<Long, QueryResult> getRecipeIngredientBatch(@Param("idList") Set<Long> idList);

    /**
     *
     * @param idList
     * @return
     */
    @MapKey("id")
    @Select({
            "<script>" +
                    "select recipe_id as id, GROUP_CONCAT(seasoning_id ORDER BY seasoning_id SEPARATOR '|') as value\n" +
                    "from recipe_has_seasoning\n" +
                    "where recipe_id in \n" +
                    "<foreach item = 'item' index = 'index' collection = 'idList' open='(' separator=',' close=')'>" +
                    "${item}" +
                    "</foreach>" +
                    "group by recipe_id;" +
                    "</script>"
    })
    Map<Long, QueryResult> getRecipeSeasoningBatch(@Param("idList") Set<Long> idList);

    /**
     *
     * @param idList
     * @return
     */
    @Select({
            "<script>"
            + "select recipe_id, recipe_name, recipe_image from recipe\n"
            + "where recipe_id in "
            + "<foreach item='item' index='index' collection='idList' open='(' separator=',' close=')'"
            + "${item}"
            + "</foreach>"
            + "</script>"
    })
    List<RecommendRecipe.Recipe> getRecipeByIdBatch(@Param("idList") List<Long> idList);

    /**
     *
     * @return
     */
    @Select("select distinct recipe_id from recipe;")
    List<Long> getAllRecipeId();
}
