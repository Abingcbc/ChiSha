package org.sse.priceservice.model;


import lombok.Data;

/**
 * @author HPY
 */
@Data
public class User {

  private long userId;
  private String nickname;
  private String phone;
  private String email;
  private String isAuthorized;
  private long gender;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getIsAuthorized() {
    return isAuthorized;
  }

  public void setIsAuthorized(String isAuthorized) {
    this.isAuthorized = isAuthorized;
  }


  public long getGender() {
    return gender;
  }

  public void setGender(long gender) {
    this.gender = gender;
  }

}
