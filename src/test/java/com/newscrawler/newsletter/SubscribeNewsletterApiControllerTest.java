package com.newscrawler.newsletter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class SubscribeNewsletterApiControllerTest {
    @Autowired MockMvc mockMvc;
    @Autowired EmailService emailService;

    private final String URL_SUBSCRIBE = "/subscribe";

    @Test
    @DisplayName("구독할 이메일 등록 테스트")
    void testSubscribe() throws Exception {
        String email = "test@mail.com";
        mockMvc.perform(post(URL_SUBSCRIBE)
                .param("email", email))
                .andExpect(status().isOk());

        String savedEmail = emailService.getEmails().get(0).getEmail();
        assertEquals(savedEmail, email);
    }
}