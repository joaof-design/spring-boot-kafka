package com.demo.kafka.controller;

import com.demo.kafka.engine.MessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

    private MessageProducer producer;

    public KafkaController(MessageProducer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public ResponseEntity sendMessage(@RequestBody String message) {

        this.producer.sendMessage(message);

        return ResponseEntity.ok().build();
    }
}
