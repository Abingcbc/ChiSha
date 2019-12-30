package org.sse.userservice.dto;

import lombok.Data;

/**
 * @author cbc
 */
@Data
public class UserShow {

    private long userId;
    private String nickname;
    private String phone;
    private String email;
    private String isAuthorized;
    private long gender;
    private String bornPlace;
    private long age;

}
