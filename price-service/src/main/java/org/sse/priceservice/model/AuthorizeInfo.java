package com.sample;


public class AuthorizeInfo {

  private long authorizeId;
  private String authorizeDescription;
  private long userId;
  private long isHandling;
  private String result;


  public long getAuthorizeId() {
    return authorizeId;
  }

  public void setAuthorizeId(long authorizeId) {
    this.authorizeId = authorizeId;
  }


  public String getAuthorizeDescription() {
    return authorizeDescription;
  }

  public void setAuthorizeDescription(String authorizeDescription) {
    this.authorizeDescription = authorizeDescription;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getIsHandling() {
    return isHandling;
  }

  public void setIsHandling(long isHandling) {
    this.isHandling = isHandling;
  }


  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

}
