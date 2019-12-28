package org.sse.priceservice.model;

import lombok.Data;

/**
 * @author HPY
 */
@Data
public class UserLikePost {

  private long userId;
  private long postId;
  private long isLike;


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


  public long getIsLike() {
    return isLike;
  }

  public void setIsLike(long isLike) {
    this.isLike = isLike;
  }

}
