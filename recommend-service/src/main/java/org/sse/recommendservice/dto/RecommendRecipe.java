package org.sse.recommendservice.dto;

import lombok.Data;

import java.util.List;

/**
 * @author cbc
 */
@Data
public class RecommendRecipe {
    @Data
    public static class Recipe {
        private Long recipeId;
        private String recipeName;
        private String recipeImage;
    }

    private List<Recipe> recipeList;
}
