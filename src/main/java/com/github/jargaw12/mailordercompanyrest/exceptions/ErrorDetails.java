package com.github.jargaw12.mailordercompanyrest.exceptions;

import java.util.Date;
import java.util.List;

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private List<String> details;

    public ErrorDetails(Date timestamp, String message, List<String> details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public ErrorDetails setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorDetails setMessage(String message) {
        this.message = message;
        return this;
    }

    public List<String> getDetails() {
        return details;
    }

    public ErrorDetails setDetails(List<String> details) {
        this.details = details;
        return this;
    }
}