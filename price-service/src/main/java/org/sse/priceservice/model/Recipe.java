package org.sse.priceservice.model;


import lombok.Data;

/**
 * @author HPY
 */
@Data
public class Recipe {

  private long recipeId;
  private String recipeName;
  private String recipeImage;
  private String recipeDescription;
  private String method;


  public long getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
  }


  public String getRecipeName() {
    return recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }


  public String getRecipeImage() {
    return recipeImage;
  }

  public void setRecipeImage(String recipeImage) {
    this.recipeImage = recipeImage;
  }


  public String getRecipeDescription() {
    return recipeDescription;
  }

  public void setRecipeDescription(String recipeDescription) {
    this.recipeDescription = recipeDescription;
  }


  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

}
