package com.example.Nabiabad_high_school.testpurpose;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin("*")
public class TestController {

    @GetMapping("/testMessege")
    public String testMessege() {
        return "Welcome";
    }

}
