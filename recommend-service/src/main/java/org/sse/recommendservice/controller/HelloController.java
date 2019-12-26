package org.sse.recommendservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HPY
 */
@RestController
public class HelloController {
    @GetMapping("/helloo")
    public String sayHello(){
        return "hello";
    }
}
