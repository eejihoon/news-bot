package com.newscrawler.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class EmailMessage {
    private String to, subject, message;
}
