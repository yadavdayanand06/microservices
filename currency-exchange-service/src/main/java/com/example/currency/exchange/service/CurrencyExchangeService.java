package com.example.currency.exchange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.currency.exchange.entity.CurrencyExchange;
import com.example.currency.exchange.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	/**
	 * 
	 * @param currencyExchange
	 * @return
	 */
	public CurrencyExchange save(CurrencyExchange currencyExchange) {
		
		return currencyExchangeRepository.save(currencyExchange);
	}
	
	/**
	 * 
	 * @param fromCurrency
	 * @param toCurrency
	 * @return
	 */
	public List<CurrencyExchange> findByToAndFromCurrency(String fromCurrency, String toCurrency) {		
		
		List<CurrencyExchange> currencyExchange = null;					
		currencyExchange=currencyExchangeRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
		return currencyExchange;
	}
}
