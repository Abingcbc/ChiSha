package org.sse.priceservice.model;


import lombok.Data;

/**
 * @author HPY
 */
@Data
public class Style {

  private long styleId;
  private String styleName;


  public long getStyleId() {
    return styleId;
  }

  public void setStyleId(long styleId) {
    this.styleId = styleId;
  }


  public String getStyleName() {
    return styleName;
  }

  public void setStyleName(String styleName) {
    this.styleName = styleName;
  }

}
