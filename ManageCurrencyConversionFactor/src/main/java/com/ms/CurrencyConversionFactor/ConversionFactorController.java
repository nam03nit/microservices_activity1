package com.ms.CurrencyConversionFactor;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ConversionFactorController {

	@Autowired
	private ConversionFactorJPARepository repo;

	@RequestMapping(path = "/get/{countryCode}", method = RequestMethod.GET)
	public double getConversionFactor(@PathVariable("countryCode") String countryCode) {
		Optional<ConversionFactor> conversionFactor = repo.findById(countryCode);
    	  if(conversionFactor.isPresent())
		  {
			  return conversionFactor.get().getConversionFactor();
		  }	
    	
       return 0;		
	}
	
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String setConversionFactor(@RequestParam(value="countryCode", defaultValue="default") String countryCode,@RequestParam(value="conversionFactor") double conversionFactor) {
		Optional<ConversionFactor> conversionFactorValue = repo.findById(countryCode);
				
		if(!(conversionFactorValue.isPresent())) {
			repo.save(new ConversionFactor(countryCode, conversionFactor));
			return "Value is set";
		}
		else {
			return "CountryCode is already present";
		}
	}
		
	
	
		@RequestMapping(path = "/update", method = RequestMethod.PUT)
		public String updateConversionFactor(@RequestParam(value="countryCode", defaultValue="default") String countryCode,@RequestParam(value="conversionFactor") double conversionFactor) {	
			Optional<ConversionFactor> conversionFactorValue = repo.findById(countryCode);
			
			if((conversionFactorValue.isPresent()))
			{
				//conversionFactorValue.get().setConversionFactor(conversionFactor);
				repo.save(new ConversionFactor(countryCode, conversionFactor));
				return "Value is updated";
			}
			else {
				return "CountryCode is not present";
			}

		
	}

}