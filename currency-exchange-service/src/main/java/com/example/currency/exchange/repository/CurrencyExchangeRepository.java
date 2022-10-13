package com.example.currency.exchange.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.currency.exchange.entity.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{

	/**
	 * 
	 * @param fromCurrency
	 * @param toCurrency
	 * @return
	 */
	public List<CurrencyExchange> findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
