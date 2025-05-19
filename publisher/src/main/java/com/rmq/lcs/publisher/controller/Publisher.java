package com.rmq.lcs.publisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rmq.lcs.publisher.service.PublisherService;

@RestController
public class Publisher {
	
	@Value("${rabbitmq.queuename}")
	private String queueName;
	
	@Autowired
	private PublisherService publisherService;
	
	@PostMapping("/publish/text")
	public void publishText(@RequestBody String text) {
		System.out.println("Sending message: " + text);
		publisherService.publishTextMessage(text, queueName);
	}

}
