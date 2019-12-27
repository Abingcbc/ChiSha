package org.sse.userservice.model;

import lombok.Data;

/**
 * @author cbc
 */
@Data
public class Result {
    private int code;
    private String msg;

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
