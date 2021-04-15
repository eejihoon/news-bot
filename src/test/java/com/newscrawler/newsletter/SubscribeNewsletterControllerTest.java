package com.newscrawler.newsletter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class SubscribeNewsletterControllerTest {
    public static final String SUSBSCRIBE = "/subscribe";
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("구독하기 페이지 출력 테스트")
    void testFormSubscribe() throws Exception {
        mockMvc.perform(get(SUSBSCRIBE))
                .andExpect(status().isOk());
                //.andExpect(content().string(""));
    }

}