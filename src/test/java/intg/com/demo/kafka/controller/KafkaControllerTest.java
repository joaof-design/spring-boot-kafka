package com.demo.kafka.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KafkaControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void sendMessage() {
        String message = "message to send";
        HttpEntity<String> msg = new HttpEntity<>(message);

        ResponseEntity<String> response = restTemplate.exchange("/api/v1/kafka/publish", HttpMethod.POST, msg, String.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
