package org.acme.api.exceptionhandler;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Error {
    private LocalDateTime localDateTime;
    private String message;

    public Error(LocalDateTime localDateTime, String message) {
        this.localDateTime = localDateTime;
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
