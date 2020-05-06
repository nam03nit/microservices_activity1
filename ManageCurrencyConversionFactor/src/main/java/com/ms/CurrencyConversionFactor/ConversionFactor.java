package com.ms.CurrencyConversionFactor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "conversion_factor")
public class ConversionFactor  {
	
	@Column(name = "countryCode")
	@Id
	private String countryCode;
	
	@Column(name = "conversionFactor")
	private double conversionFactor;

	
	public ConversionFactor(String countryCode, double conversionFactor) {
		super();
		
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
		
	}

	public ConversionFactor() {
		super();
	}
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

}
