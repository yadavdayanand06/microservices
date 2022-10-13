package com.example.currency.exchange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "from_currency", unique = true)
	private String fromCurrency;
	@Column(name = "to_currency")
	private String toCurrency;
	@Column(name="conversion_rate",nullable = false)
	private double conversionRate;
	
	/**
	 * no arg constructor
	 */
	public CurrencyExchange() {}
	
	/**
	 * @param id
	 * @param fromCurrency
	 * @param toCurrency
	 * @param conversionRate
	 */
	public CurrencyExchange(long id, String fromCurrency, String toCurrency, double conversionRate) {
		this.id = id;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.conversionRate = conversionRate;
	}

	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", fromCurrency=" + fromCurrency + ", toCurrency=" + toCurrency
				+ ", conversionRate=" + conversionRate + "]";
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the fromCurrency
	 */
	public String getFromCurrency() {
		return fromCurrency;
	}

	/**
	 * @param fromCurrency the fromCurrency to set
	 */
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	/**
	 * @return the toCurrency
	 */
	public String getToCurrency() {
		return toCurrency;
	}

	/**
	 * @param toCurrency the toCurrency to set
	 */
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	/**
	 * @return the conversionRate
	 */
	public double getConversionRate() {
		return conversionRate;
	}

	/**
	 * @param conversionRate the conversionRate to set
	 */
	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}
	
	
	
}
