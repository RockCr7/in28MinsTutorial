package com.lcwd.microservice.Bean;

import java.math.BigDecimal;

public class CurrencyCoversionBean {
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal inputQuantity;
	private BigDecimal calculatedAmount;
	private int port;

	public CurrencyCoversionBean() {

	}

	public CurrencyCoversionBean(Long id, String from, String to, BigDecimal conversionMultiple,
			BigDecimal inputQuantity, BigDecimal calculatedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.inputQuantity = inputQuantity;
		this.calculatedAmount = calculatedAmount;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getInputQuantity() {
		return inputQuantity;
	}

	public void setInputQuantity(BigDecimal inputQuantity) {
		this.inputQuantity = inputQuantity;
	}

	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}

	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
