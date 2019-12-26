package org.sse.recommendservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cbc
 */
public class RecommendController {
    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }
}
