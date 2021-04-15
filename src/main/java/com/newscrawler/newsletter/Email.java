package com.newscrawler.newsletter;

import lombok.Getter;

@Getter
public class Email {
    private String email;

    public Email(String email) {
        this.email = email;
    }
}
