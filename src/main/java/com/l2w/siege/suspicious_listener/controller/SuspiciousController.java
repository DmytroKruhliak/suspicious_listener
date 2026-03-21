package com.l2w.siege.suspicious_listener.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.l2w.siege.suspicious_listener.model.SuspiciousResponse;

@RestController
public class SuspiciousController {

    @GetMapping("/suspicious")
    public SuspiciousResponse getSuspicious() {
        return new SuspiciousResponse("This is a suspicious endpoint!", 1L);
    }

    @GetMapping("/suspicious/info")
    public SuspiciousResponse getSuspiciousInfo() {
        return new SuspiciousResponse("This is some suspicious information!", 2L);
    }
}
