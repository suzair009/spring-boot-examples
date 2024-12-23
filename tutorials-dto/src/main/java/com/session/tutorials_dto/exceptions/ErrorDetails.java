package com.session.tutorials_dto.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


public class ErrorDetails {
    public ErrorDetails() {
    }

    private LocalDateTime timestamp;
    private String message;
    private String errorCode;
    private String path;

    public ErrorDetails(LocalDateTime timestamp, String message, String path, String errorCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
        this.errorCode = errorCode;
    }



    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }


}
