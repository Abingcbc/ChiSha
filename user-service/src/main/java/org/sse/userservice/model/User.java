package org.sse.userservice.model;

import lombok.Data;

/**
 * @author cbc
 */
@Data
public class User {

  private long userId;
  private String nickname;
  private String phone;
  private String email;
  private String isAuthorized;
  private long gender;
  private String password;
  private long bornPlace;
  private long age;

}
