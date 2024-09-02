package com.mikrelin.springbootbackend.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    @GetMapping("/demo")
    public String demo() {
        return "Hello World";
    }
}
