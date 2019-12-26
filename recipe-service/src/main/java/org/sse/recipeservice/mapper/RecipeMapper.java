package org.sse.recipeservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.sse.recipeservice.model.Recipe;


import java.util.List;

/**
 * @author HPY
 */
@Component
@Mapper
public interface RecipeMapper {

    /**
     * get a page of recipe
     * @return
     */
    @Select("SELECT \n" +
            "    recipe_id, recipe_name, recipe_image\n" +
            "FROM\n" +
            "    recipe")
    List<Recipe> getPageOfRecipe();

    /**
     * search
     * @param name keyword
     * @return recipes
     */
    @Select("SELECT \n" +
            "    recipe_id, recipe_name, recipe_image\n" +
            "FROM\n" +
            "    recipe\n" +
            "WHERE\n" +
            "    recipe_name LIKE #{name}")
    List<Recipe> getRecipeByKeyword(@Param("name") String name);

    /**
     * get recipe by style
     * @param styleId
     * @return
     */
    @Select("SELECT \n" +
            "    recipe.recipe_id, recipe_name, recipe_image\n" +
            "FROM\n" +
            "    recipe\n" +
            "        JOIN\n" +
            "    recipe_has_style ON recipe.recipe_id = recipe_has_style.recipe_id\n" +
            "WHERE\n" +
            "    style_id = #{styleId}")
    List<Recipe> getRecipeByStyle(@Param("styleId") int styleId);
}
