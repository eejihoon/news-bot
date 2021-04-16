package com.newscrawler.newsletter;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class EmailAddress {
    @NotBlank @Email
    private String email;

    public EmailAddress(String email) {
        this.email = email;
    }
}
