package com.sample;


public class BrowsingHistory {

  private long browseId;
  private long userId;
  private long recipeId;
  private java.sql.Timestamp browseTime;


  public long getBrowseId() {
    return browseId;
  }

  public void setBrowseId(long browseId) {
    this.browseId = browseId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
  }


  public java.sql.Timestamp getBrowseTime() {
    return browseTime;
  }

  public void setBrowseTime(java.sql.Timestamp browseTime) {
    this.browseTime = browseTime;
  }

}
