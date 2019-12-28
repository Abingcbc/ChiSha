package org.sse.recipeservice.dto;

import lombok.Data;

import java.util.List;

/**
 * @author HPY
 */
@Data
public class RecipeDTO {
    Long recipeId;
    String recipeName;
    String recipeImage;
    String recipeDescription;
    String method;
    List<RecipeHasIngredientDTO> ingredients;
    List<RecipeHasSeasoningDTO> seasonings;
    List<RecipeHasStyleDTO> styles;
    List<RecipeHasTasteDTO> tastes;
}
