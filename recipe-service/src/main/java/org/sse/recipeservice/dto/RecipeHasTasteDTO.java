package org.sse.recipeservice.dto;

import lombok.Data;

/**
 * @author HPY
 */
@Data
public class RecipeHasTasteDTO {
    Long recipeId;
    Long tasteId;
    String tasteName;
}
