package com.project.currencyrates.model.daily;

import java.util.StringJoiner;

/**
 * The type Currency rate dto. Holds the returned to the customer currency and rate.
 */
public class CurrencyRateDto {

    private String currency;
    private String rate;

    /**
     * Instantiates a new Currency rate dto.
     *
     * @param currency the currency
     * @param rate     the rate
     */
    public CurrencyRateDto(String currency, String rate) {
        this.currency = currency;
        this.rate = rate;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets currency.
     *
     * @param currency the currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets rate.
     *
     * @return the rate
     */
    public String getRate() {
        return rate;
    }

    /**
     * Sets rate.
     *
     * @param rate the rate
     */
    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CurrencyRateDto.class.getSimpleName() + "[", "]")
                .add("currency='" + currency + "'")
                .add("rate='" + rate + "'")
                .toString();
    }
}