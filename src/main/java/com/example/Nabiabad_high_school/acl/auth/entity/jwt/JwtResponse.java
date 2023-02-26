package com.example.Nabiabad_high_school.acl.auth.entity.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtResponse {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    String token;

    public JwtResponse(String token) {
        this.token = token;
    }
}
