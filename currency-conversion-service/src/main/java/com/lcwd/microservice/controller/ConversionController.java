package com.lcwd.microservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lcwd.microservice.Bean.CurrencyCoversionBean;
import com.lcwd.microservice.Bean.CurrencyExchangeProxy;

@RestController
public class ConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CurrencyExchangeProxy prox;

	@Autowired
	private RestTemplate restTemp;

	@GetMapping("/currency-converter/{from}/{to}/{quantity}")
	public CurrencyCoversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyCoversionBean> forEntity = restTemp.getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyCoversionBean.class,
				uriVariables);
		CurrencyCoversionBean ccBean = forEntity.getBody();
		logger.info("{}",ccBean);
		
		return new CurrencyCoversionBean(ccBean.getId(), from, to, ccBean.getConversionMultiple(), quantity,
				quantity.multiply(ccBean.getConversionMultiple()), ccBean.getPort());
	}

	@GetMapping("/currency-converter-feign/{from}/{to}/{quantity}")
	public CurrencyCoversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		CurrencyCoversionBean ccBean = prox.calculateCurrency(from, to);
		logger.info("{}",ccBean);

		return new CurrencyCoversionBean(ccBean.getId(), from, to, ccBean.getConversionMultiple(), quantity,
				quantity.multiply(ccBean.getConversionMultiple()), ccBean.getPort());
	}
}
