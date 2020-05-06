package com.ms.ConvertCurrency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ms.ConvertCurrency.dao.ConversionFactorFetch;
import com.ms.ConvertCurrency.domain.ConversionFactor;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;




@Service()
public class ConvertCurrencyServiceImp implements ConvertCurrencyService{

	@Autowired
	private ConversionFactorFetch conversionFactorFetch;
	
	@HystrixCommand(fallbackMethod="getAmount01")
	public double getAmount(double amount, String countryCode) {
		double conversionFactor = conversionFactorFetch.getConversionFactor(countryCode);
		double convertedAmount = amount*conversionFactor;
		return convertedAmount;
	}
	
	public double getAmount01(double amount, String countryCode) {		
		return 0.0;

	}
	
}
