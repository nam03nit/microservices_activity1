package com.ms.ConvertCurrency.service;

public interface ConvertCurrencyService {
	public double getAmount(double amount, String countryCode);
	public String addValues(String countryCode, double conversionFactor);
	public String updateValues(String countryCode, double conversionFactor);

}
