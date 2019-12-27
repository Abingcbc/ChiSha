package org.sse.recommendservice.dto;

import lombok.Data;

/**
 * @author cbc
 */
@Data
public class BrowsingPlus {
    private long userId;
    private long gender;
    private long age;
    private long bornPlace;
    private long recipeId;
}
