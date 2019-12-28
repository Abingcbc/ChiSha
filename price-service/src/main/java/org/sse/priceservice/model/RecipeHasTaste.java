package org.sse.priceservice.model;


import lombok.Data;

/**
 * @author HPY
 */
@Data
public class RecipeHasTaste {

  private long recipeId;
  private long tasteId;


  public long getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
  }


  public long getTasteId() {
    return tasteId;
  }

  public void setTasteId(long tasteId) {
    this.tasteId = tasteId;
  }

}
