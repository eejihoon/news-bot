package com.newscrawler.newsletter.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @EqualsAndHashCode(of = "email")
@Entity
public class EmailAddress {
    @Id @GeneratedValue
    Long id;

    @NotBlank @Email
    private String email;

    public EmailAddress(String email) {
        this.email = email;
    }
}
