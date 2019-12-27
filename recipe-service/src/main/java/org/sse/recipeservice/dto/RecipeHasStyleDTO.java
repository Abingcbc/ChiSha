package org.sse.recipeservice.dto;

import lombok.Data;

/**
 * @author HPY
 */
@Data
public class RecipeHasStyleDTO {
    Long recipeId;
    Long styleId;
    String styleName;
}
