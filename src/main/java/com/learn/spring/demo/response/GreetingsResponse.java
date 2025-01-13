package com.learn.spring.demo.response;

public class GreetingsResponse {
    private String message;

    public GreetingsResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
