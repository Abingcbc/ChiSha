package com.sample;


public class UserComplainsPost {

  private long complainId;
  private long userId;
  private long postId;
  private java.sql.Timestamp createTime;
  private long isHandling;
  private String reason;


  public long getComplainId() {
    return complainId;
  }

  public void setComplainId(long complainId) {
    this.complainId = complainId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getPostId() {
    return postId;
  }

  public void setPostId(long postId) {
    this.postId = postId;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public long getIsHandling() {
    return isHandling;
  }

  public void setIsHandling(long isHandling) {
    this.isHandling = isHandling;
  }


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

}
