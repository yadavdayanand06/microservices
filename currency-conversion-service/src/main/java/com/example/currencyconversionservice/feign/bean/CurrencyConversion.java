package com.example.currencyconversionservice.feign.bean;

public class CurrencyConversion {

	private long id;
	private String fromCurrency;
	private String toCurrency;
	private double conversionRate;
	
	/**
	 * no arg constructor
	 */
	public CurrencyConversion() {}
	
	/**
	 * @param id
	 * @param fromCurrency
	 * @param toCurrency
	 * @param conversionRate
	 */
	public CurrencyConversion(long id, String fromCurrency, String toCurrency, double conversionRate) {
		this.id = id;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.conversionRate = conversionRate;
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

	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", fromCurrency=" + fromCurrency + ", toCurrency=" + toCurrency
				+ ", conversionRate=" + conversionRate + "]";
	}
	
	
	
}
