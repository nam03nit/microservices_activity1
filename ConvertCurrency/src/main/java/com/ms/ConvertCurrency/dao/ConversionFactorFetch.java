package com.ms.ConvertCurrency.dao;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ms.ConvertCurrency.domain.ConversionFactor;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@FeignClient("CONVERSIONFACTOR")
@RibbonClient("CONVERSIONFACTOR")
public interface ConversionFactorFetch {
		
	
	@RequestMapping(path= "/get/{countryCode}", method=RequestMethod.GET)
	public double getConversionFactor(@PathVariable("countryCode") String countryCode);
	
	@RequestMapping(path= "/add/", method=RequestMethod.POST)
	public String addConversionFactor(@RequestParam("countryCode") String countryCode, @RequestParam("conversionFactor") double conversionFactor);
	
	@RequestMapping(path= "/update/", method=RequestMethod.PUT)
	public String updateConversionFactor(@RequestParam("countryCode") String countryCode, @RequestParam("conversionFactor") double conversionFactor);
	
	
		
	
	
}
