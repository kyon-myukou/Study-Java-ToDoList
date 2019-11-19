package com.kyon.todolist.Controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration

public class HelloSpring {
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello Spring";
    }
}
