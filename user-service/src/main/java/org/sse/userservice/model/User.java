package org.sse.userservice.model;


import lombok.Data;

/**
 * @author cbc
 */
@Data
public class User {

  private String username;
  private String password;
  private String email;
  private String avatarUrl;
  private int likeNum;

}
