package com.newscrawler.newsletter;

public class EmailAddressDuplicateException extends Exception {
    public EmailAddressDuplicateException(String msg) {
        super(msg);
    }
}
