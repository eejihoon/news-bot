package com.newscrawler.newsletter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@RequiredArgsConstructor
@Component
public class EmailAddressValidator implements Validator {
    private final EmailService emailService;
    @Override
    public boolean supports(Class<?> clazz) {
        //어떤 클래스를 Validation 할 것인지
        return clazz.isAssignableFrom(EmailAddress.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmailAddress emailAddress = (EmailAddress) target;

        if (isExistsEmail(emailAddress))
            errors.rejectValue("email", "duplicate-email", new Object[]{emailAddress.getEmail()}, "이미 등록된 이메일입니다.");
    }

    private boolean isExistsEmail(EmailAddress emailAddress) {
        return emailService.getEmails().contains(emailAddress);
    }
}
