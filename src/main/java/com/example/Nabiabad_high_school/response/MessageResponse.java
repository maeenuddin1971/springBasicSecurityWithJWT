package com.example.Nabiabad_high_school.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MessageResponse {
    private String message;
    private Boolean status;
    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public MessageResponse(String message) {
        this.message = message;
    }

    public MessageResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public MessageResponse(String message, Boolean status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }
}
