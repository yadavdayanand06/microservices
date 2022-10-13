package com.example.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyconversionservice.feign.bean.CurrencyConversion;
import com.example.currencyconversionservice.feign.proxy.CurrencyExchangeProxy;
import com.example.currencyconversionservice.service.CurrencyConversionService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	@Autowired
	private CurrencyConversionService service;

	@GetMapping("/convert/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<BigDecimal> getConvertedCurrencyValue(@PathVariable String from,
			                                                    @PathVariable String to,
			                                                    @PathVariable BigDecimal quantity){
		BigDecimal convertedValue=BigDecimal.ZERO;
		
		final ResponseEntity<List<CurrencyConversion>> responseEntity = currencyExchangeProxy.get(from, to);
		
		final List<CurrencyConversion> body = responseEntity.getBody();
		
		 CurrencyConversion currencyConversion =null;
		
		if(body!=null && !body.isEmpty()) {
			 currencyConversion = body.get(0);
			 convertedValue = BigDecimal.valueOf(quantity.doubleValue()*currencyConversion.getConversionRate());
		}		
		
		return ResponseEntity.ok(convertedValue);
				
	}
	
	@GetMapping("/circuitBreaker")
	public String circuitBreaker(HttpServletRequest request){
		return service.circuitBreaker(request.getSession().getId());
	}
	
	@GetMapping("/timelimitter")
	public String timelimitter(HttpServletRequest request) throws InterruptedException, ExecutionException {
		return service.timelimitter().get();
	}
	
	@GetMapping("/ratelimitter")
	public String ratelimitter(HttpServletRequest request) throws InterruptedException, ExecutionException {
		return service.rateLimitter();
	}
}
