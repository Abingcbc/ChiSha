package org.sse.priceservice.model;

import lombok.Data;

/**
 * @author HPY
 */
@Data
public class UserPreferStyle {

  private long userId;
  private long styleId;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getStyleId() {
    return styleId;
  }

  public void setStyleId(long styleId) {
    this.styleId = styleId;
  }

}
