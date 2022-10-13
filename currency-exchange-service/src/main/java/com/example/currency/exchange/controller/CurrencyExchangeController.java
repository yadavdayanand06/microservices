package com.example.currency.exchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.currency.exchange.entity.CurrencyExchange;
import com.example.currency.exchange.service.CurrencyExchangeService;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeService exchangeService;
	
	@GetMapping("/get/{fromCurrency}/{toCurrency}")
	public  ResponseEntity<List<CurrencyExchange>> get(@PathVariable(name = "fromCurrency") String fromCurrency ,
														@PathVariable(name = "toCurrency") String toCurrency){
		final List<CurrencyExchange> currencyExchange = exchangeService.findByToAndFromCurrency(fromCurrency, toCurrency);
		
		return ResponseEntity.ok(currencyExchange);
	}

	@PostMapping("/save")
	public ResponseEntity<CurrencyExchange> save(@RequestBody CurrencyExchange currencyExchange) {
		final CurrencyExchange savedCurrencyExchange = exchangeService.save(currencyExchange);
		
		return ResponseEntity.ok().body(savedCurrencyExchange);
	}
}
