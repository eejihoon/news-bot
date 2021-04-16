package com.newscrawler.newsletter;

import lombok.Getter;

@Getter
public class EmailAddress {
    private String email;

    public EmailAddress(String email) {
        this.email = email;
    }
}
