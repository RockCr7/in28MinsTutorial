package com.lcwd.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.microservice.entities.ExchangeValue;

public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from,String to);
}
