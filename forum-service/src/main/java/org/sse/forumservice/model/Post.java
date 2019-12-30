package org.sse.forumservice.model;


public class Post {

  private long postId;
  private String title;
  private String content;
  private long likeNum;
  private long commentNum;
  private long isDelete;
  private String contact;
  private String postImage;
  private java.sql.Timestamp createTime;
  private long userId;


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


  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }


  public String getPostImage() {
    return postImage;
  }

  public void setPostImage(String postImage) {
    this.postImage = postImage;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

}
