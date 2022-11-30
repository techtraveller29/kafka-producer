package com.mytechjourney.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytechjourney.kafkaproducer.model.Customer;


@RestController
@RequestMapping("/kafka")
public class KafkaController {
    
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${topic.name}")
    String topic;

    @PostMapping("/sendString/{message}")
    public String sendStringMessage(@PathVariable(name = "message") String message){
        kafkaTemplate.send(topic, message);
        return "Message sent successfully.";
    }

    @PostMapping("/sendObject")
    public String sendStringMessage(@RequestBody Customer customer){
        kafkaTemplate.send(topic, customer);
        return "Message sent successfully.";
    }
}