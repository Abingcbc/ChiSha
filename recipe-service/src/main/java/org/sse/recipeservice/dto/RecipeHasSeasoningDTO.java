package org.sse.recipeservice.dto;

import lombok.Data;

/**
 * @author HPY
 */
@Data
public class RecipeHasSeasoningDTO {
    Long recipeId;
    Long seasoningId;
    String seasoningName;
    String quantity;
}
