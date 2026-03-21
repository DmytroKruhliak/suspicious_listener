package com.l2w.siege.suspicious_listener.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SuspiciousResponse {
    private String message;
    private long id;

    public String getMessage() {
        return message;
    }

    public long getId() {
        return id;
    }
}
