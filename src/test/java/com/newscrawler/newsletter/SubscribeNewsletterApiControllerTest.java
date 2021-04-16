package com.newscrawler.newsletter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class SubscribeNewsletterApiControllerTest {
    @Autowired MockMvc mockMvc;
    @Autowired EmailService emailService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String URL_SUBSCRIBE = "/api/subscribe";

    @Test
    @DisplayName("구독할 이메일 등록 테스트")
    void testSubscribe() throws Exception {
        String email = "test@mail.com";
        mockMvc.perform(post(URL_SUBSCRIBE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(email)))
                .andExpect(status().isOk());

        String savedEmail = emailService.getEmails().get(0).getEmail();
        assertEquals(savedEmail, email);
    }

    @Test
    @DisplayName("이메일 필드에 공백 입력 테스트")
    void testEnterWhiteSpaceInEmailField() throws Exception {
        String email = "";
        mockMvc.perform(post(URL_SUBSCRIBE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(email)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("이메일 필드에 이메일이 아닌 텍스트 입력 테스트")
    void testEnterOtherTextInEmailField() throws Exception {
        String email = "NoEmail!";
        mockMvc.perform(post(URL_SUBSCRIBE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(email)))
                .andExpect(status().is4xxClientError());
    }
}