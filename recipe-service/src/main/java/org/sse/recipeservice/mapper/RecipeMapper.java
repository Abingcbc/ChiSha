package org.sse.recipeservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.sse.recipeservice.dto.*;
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

    /**
     * get recipe info by recipe id
     * @param id recipe id
     * @return recipe
     */
    @Select("SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    recipe\n" +
            "WHERE\n" +
            "    recipe_id = #{id}")
    RecipeDTO getRecipeById(@Param("id") long id);

    /**
     * get ingredients by recipe id
     * @param recipeId recipe id
     * @return list of ingredients
     */
    @Select("SELECT \n" +
            "    recipe.recipe_id,\n" +
            "    ingredient.ingredient_id,\n" +
            "    ingredient_name,\n" +
            "    ingredient_image,\n" +
            "    quantity\n" +
            "FROM\n" +
            "    recipe\n" +
            "        JOIN\n" +
            "    recipe_has_ingredient ON recipe.recipe_id = recipe_has_ingredient.recipe_id\n" +
            "        JOIN\n" +
            "    ingredient ON recipe_has_ingredient.ingredient_id = ingredient.ingredient_id\n" +
            "WHERE\n" +
            "    recipe.recipe_id = #{id}")
    List<RecipeHasIngredientDTO> getIngredientsByRecipeId(@Param("id") long recipeId);

    /**
     * get seasonings by recipe id
     * @param recipeId recipe id
     * @return seasonings
     */
    @Select("SELECT \n" +
            "    recipe.recipe_id,\n" +
            "    seasoning.seasoning_id,\n" +
            "    seasoning_name,\n" +
            "    \n" +
            "    quantity\n" +
            "FROM\n" +
            "    recipe\n" +
            "        JOIN\n" +
            "    recipe_has_seasoning ON recipe.recipe_id = recipe_has_seasoning.recipe_id\n" +
            "        JOIN\n" +
            "    seasoning ON recipe_has_seasoning.seasoning_id = seasoning.seasoning_id\n" +
            "WHERE\n" +
            "    recipe.recipe_id = #{id}")
    List<RecipeHasSeasoningDTO> getSeasoningsByRecipeId(@Param("id") long recipeId);

    /**
     * get tastes by recipe id
     * @param recipeId recipe id
     * @return tastes
     */
    @Select("SELECT \n" +
            "    recipe.recipe_id, taste.taste_id, taste_name\n" +
            "FROM\n" +
            "    recipe\n" +
            "        JOIN\n" +
            "    recipe_has_taste ON recipe.recipe_id = recipe_has_taste.recipe_id\n" +
            "        JOIN\n" +
            "    taste ON recipe_has_taste.taste_id = taste.taste_id\n" +
            "WHERE\n" +
            "    recipe.recipe_id = #{id}")
    List<RecipeHasTasteDTO> getTastesByRecipeId(@Param("id") long recipeId);

    /**
     * get styles by recipe id
     * @param recipeId recipe id
     * @return styles
     */
    @Select("SELECT \n" +
            "    recipe.recipe_id, style.style_id, style_name\n" +
            "FROM\n" +
            "    recipe\n" +
            "        JOIN\n" +
            "    recipe_has_style ON recipe.recipe_id = recipe_has_style.recipe_id\n" +
            "        JOIN\n" +
            "    style ON recipe_has_style.style_id = style.style_id\n" +
            "WHERE\n" +
            "    recipe.recipe_id = #{id}")
    List<RecipeHasStyleDTO> getStylesByRecipeId(@Param("id") long recipeId);
}
