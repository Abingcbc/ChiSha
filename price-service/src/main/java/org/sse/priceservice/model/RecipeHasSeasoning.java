package org.sse.priceservice.model;

import lombok.Data;

/**
 * @author HPY
 */
@Data
public class RecipeHasSeasoning {

  private long recipeId;
  private long seasoningId;
  private String quantity;


  public long getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
  }


  public long getSeasoningId() {
    return seasoningId;
  }

  public void setSeasoningId(long seasoningId) {
    this.seasoningId = seasoningId;
  }


  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

}
