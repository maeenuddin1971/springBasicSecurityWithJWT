package com.example.Nabiabad_high_school.acl.auth.entity.settings;

import com.example.Nabiabad_high_school.entity.system.baseEnitiy.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity(name = "AUTH_TYPE")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthType extends BaseEntity {
    private String authType;

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }
}