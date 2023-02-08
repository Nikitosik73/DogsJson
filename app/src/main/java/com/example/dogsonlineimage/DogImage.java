package com.example.dogsonlineimage;

public class DogImage {

    private String status;
    private String message;

    public DogImage(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
