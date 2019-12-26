package org.sse.recommendservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cbc
 */
@RestController
public class RecommendController {
    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }
}
