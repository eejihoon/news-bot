package com.newscrawler.newsletter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter @EqualsAndHashCode(of = "email")
public class EmailAddress {
    @NotBlank @Email
    private String email;

    public EmailAddress(String email) {
        this.email = email;
    }
}
