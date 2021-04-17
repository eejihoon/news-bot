package com.newscrawler.newsletter.exception;

public class EmailAddressDuplicateException extends Exception {
    public EmailAddressDuplicateException(String msg) {
        super(msg);
    }
}
