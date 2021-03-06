package org.sse.priceservice.model;


import lombok.Data;

/**
 * @author HPY
 */
@Data
public class Seasoning {

  private long seasoningId;
  private String seasoningName;


  public long getSeasoningId() {
    return seasoningId;
  }

  public void setSeasoningId(long seasoningId) {
    this.seasoningId = seasoningId;
  }


  public String getSeasoningName() {
    return seasoningName;
  }

  public void setSeasoningName(String seasoningName) {
    this.seasoningName = seasoningName;
  }

}
