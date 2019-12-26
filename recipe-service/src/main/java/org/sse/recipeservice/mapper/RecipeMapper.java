package org.sse.recipeservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
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

}
