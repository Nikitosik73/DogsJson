package com.example.dogsonlineimage;

import androidx.annotation.NonNull;

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

    @Override
    @NonNull
    public String toString() {
        return "DogImage{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
