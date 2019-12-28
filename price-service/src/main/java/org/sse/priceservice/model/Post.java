package org.sse.priceservice.model;


import lombok.Data;

/**
 * @author HPY
 */
@Data
public class Post {

  private long postId;
  private String title;
  private String content;
  private long likeNum;
  private long commentNum;
  private long isDelete;


  public long getPostId() {
    return postId;
  }

  public void setPostId(long postId) {
    this.postId = postId;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public long getLikeNum() {
    return likeNum;
  }

  public void setLikeNum(long likeNum) {
    this.likeNum = likeNum;
  }


  public long getCommentNum() {
    return commentNum;
  }

  public void setCommentNum(long commentNum) {
    this.commentNum = commentNum;
  }


  public long getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(long isDelete) {
    this.isDelete = isDelete;
  }

}
