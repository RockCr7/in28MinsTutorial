package com.lcwd.microservice.Bean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="currency-exchange-service", url ="localhost:8000")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyCoversionBean calculateCurrency(@PathVariable("from") String from, @PathVariable("to") String to);

}
