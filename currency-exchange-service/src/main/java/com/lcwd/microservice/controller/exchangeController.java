package com.lcwd.microservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.microservice.entities.ExchangeValue;
import com.lcwd.microservice.repositories.CurrencyExchangeRepository;

@RestController
@RequestMapping("/currency-exchange")
public class exchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;

	@Autowired
	CurrencyExchangeRepository currExRepo;

	@GetMapping("/from/{from}/to/{to}")
	public ExchangeValue calculateCurrency(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exVal = currExRepo.findByFromAndTo(from, to);
		exVal.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		logger.info("{}",exVal);
		
		return exVal;
	}
}
