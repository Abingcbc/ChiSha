package org.sse.recommendservice.dto;

import lombok.Data;

/**
 * @author cbc
 */
@Data
public class UserTrainField {
    private long gender;
    private long age;
    private long born_place;
    private String style;
    private String taste;
    private String hist_recipe;

    public UserTrainField(long gender, long age, long born_place, String style, String taste, String hist_recipe) {
        this.gender = gender;
        this.age = age;
        this.born_place = born_place;
        this.style = style;
        this.taste = taste;
        this.hist_recipe = hist_recipe;
    }
}
