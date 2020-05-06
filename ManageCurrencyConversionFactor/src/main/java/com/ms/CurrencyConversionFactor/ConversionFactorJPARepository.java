package com.ms.CurrencyConversionFactor;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ConversionFactorJPARepository extends JpaRepository<ConversionFactor, String>{


}
