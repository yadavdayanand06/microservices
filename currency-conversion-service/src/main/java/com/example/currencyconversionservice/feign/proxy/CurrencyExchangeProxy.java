package com.example.currencyconversionservice.feign.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.currencyconversionservice.feign.bean.CurrencyConversion;


@FeignClient(name = "currency-exchange-service")
				//url="localhost:8001/currency-exchange")
					//,url="currency-exchange-service/currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/get/{fromCurrency}/{toCurrency}")
	public  ResponseEntity<List<CurrencyConversion>> get(@PathVariable(name = "fromCurrency") String fromCurrency ,
														@PathVariable(name = "toCurrency") String toCurrency);
}
