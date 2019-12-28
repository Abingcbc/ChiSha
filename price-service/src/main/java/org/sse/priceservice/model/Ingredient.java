package org.sse.priceservice.model;


import lombok.Data;

/**
 * @author HPY
 */
@Data
public class Ingredient {

  private long ingredientId;
  private String ingredientName;
  private String ingredientImage;


  public long getIngredientId() {
    return ingredientId;
  }

  public void setIngredientId(long ingredientId) {
    this.ingredientId = ingredientId;
  }


  public String getIngredientName() {
    return ingredientName;
  }

  public void setIngredientName(String ingredientName) {
    this.ingredientName = ingredientName;
  }


  public String getIngredientImage() {
    return ingredientImage;
  }

  public void setIngredientImage(String ingredientImage) {
    this.ingredientImage = ingredientImage;
  }

}
