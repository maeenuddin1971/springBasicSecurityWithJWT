package com.example.Nabiabad_high_school.acl.auth.entity.jwt;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class JwtRequest {
    @NotBlank(message = "username must not be blank")
    String username;

    //    @Size(message = "password size must be 4 to 20", min = 4,max = 20)
    @NotBlank
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
