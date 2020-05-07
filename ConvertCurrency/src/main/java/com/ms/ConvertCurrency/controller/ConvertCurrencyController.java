package com.ms.ConvertCurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.ConvertCurrency.service.ConvertCurrencyService;

@RestController
public class ConvertCurrencyController {

	@Autowired ConvertCurrencyService convertCurrencyService;
		
	@RequestMapping(path = "/convert", method = RequestMethod.GET)
	public double getConversionFactor(@RequestParam(value="amount") double amount, @RequestParam(value="countryCode") String countryCode) {		
			return convertCurrencyService.getAmount(amount, countryCode);	
	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addConversionFactor(@RequestParam(value="countryCode") String countryCode, @RequestParam(value="conversionFactor") double conversionFactor) {		
			return convertCurrencyService.addValues(countryCode, conversionFactor);	
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	public String updateConversionFactor(@RequestParam(value="countryCode") String countryCode, @RequestParam(value="conversionFactor") double conversionFactor) {		
			return convertCurrencyService.updateValues(countryCode, conversionFactor);	
	}
	
}