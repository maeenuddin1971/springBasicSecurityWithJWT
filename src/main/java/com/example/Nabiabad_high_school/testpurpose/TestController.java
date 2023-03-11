package com.example.Nabiabad_high_school.testpurpose;


import com.example.Nabiabad_high_school.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin("*")
public class TestController {

    @GetMapping("/testMessege")
    public ResponseEntity<?> testMessege() {
        String message = "Welcome everything is working";
        return new ResponseEntity<>(new MessageResponse("Data",true,message), HttpStatus.OK);
    }

}
