package com.example.Nabiabad_high_school.acl.auth.entity;

import com.example.Nabiabad_high_school.entity.system.baseEnitiy.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpMethod;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "AUTH_REQUEST_URL")
public class RequestUrl extends BaseEntity {
    String url;
    String configAttribute;
    HttpMethod httpMethod;
    @Column(name = "CREATION_USER")
    String creationUser;
    public RequestUrl(){
    }

    public RequestUrl(String url, String configAttribute, HttpMethod httpMethod, Date creationDateTime, String creationUser) {
        this.url = url;
        this.configAttribute = configAttribute;
        this.httpMethod = httpMethod;
        this.creationUser = creationUser;
    }
}
