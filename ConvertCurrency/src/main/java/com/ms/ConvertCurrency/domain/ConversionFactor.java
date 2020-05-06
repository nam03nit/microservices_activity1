package com.ms.ConvertCurrency.domain;

public class ConversionFactor  {
	
	
	private String countryCode;
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
