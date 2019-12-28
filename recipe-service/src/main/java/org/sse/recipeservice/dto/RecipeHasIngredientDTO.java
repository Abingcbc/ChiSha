package org.sse.recipeservice.dto;

import lombok.Data;

/**
 * @author HPY
 */
@Data
public class RecipeHasIngredientDTO {
    Long recipeId;
    Long ingredientId;
    String ingredientName;
    String quantity;
    String ingredientImage;
}
