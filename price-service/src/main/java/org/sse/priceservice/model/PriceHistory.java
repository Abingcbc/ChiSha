package com.sample;


public class PriceHistory {

  private long priceHistoryId;
  private long ingredientId;
  private java.sql.Timestamp date;
  private double price;


  public long getPriceHistoryId() {
    return priceHistoryId;
  }

  public void setPriceHistoryId(long priceHistoryId) {
    this.priceHistoryId = priceHistoryId;
  }


  public long getIngredientId() {
    return ingredientId;
  }

  public void setIngredientId(long ingredientId) {
    this.ingredientId = ingredientId;
  }


  public java.sql.Timestamp getDate() {
    return date;
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

}
