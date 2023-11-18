package com.lcwd.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.microservice.bean.LimitConfiguration;
import com.lcwd.microservice.config.configuration;

@RestController
public class LimitController {
	
	@Autowired
	private configuration config;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		return new LimitConfiguration(config.getMaximum(), config.getMinimum());
	}
}
