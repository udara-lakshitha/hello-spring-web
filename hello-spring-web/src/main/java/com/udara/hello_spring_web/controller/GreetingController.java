package com.udara.hello_spring_web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 1. Tells Spring this is a REST controller.
public class GreetingController {

    // 2. Maps GET requests for http://localhost:8080/hello to this method.
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from your auto-reloaded application!";
    }

    // 3. Let's make it more interesting. This endpoint accepts a parameter.
    // URL: http://localhost:8080/greet?name=Udara
    @GetMapping("/greet")
    public String GreetUser(@RequestParam(value = "name", defaultValue = "World") String name) {
        // @RequestParam binds the 'name' parameter from the URL to the 'name' variable here.
        return "Hello " + name + "!";
    }
}
