package com.project.currencyrates.model.daily;

import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 * The type Daily currency rates response.
 */
public class DailyCurrencyRatesResponse {

    private String title;
    private Date ratesTime;
    private List<CurrencyRateDto> rates;

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets rates time.
     *
     * @return the rates time
     */
    public Date getRatesTime() {
        return ratesTime;
    }

    /**
     * Sets rates time.
     *
     * @param ratesTime the rates time
     */
    public void setRatesTime(Date ratesTime) {
        this.ratesTime = ratesTime;
    }

    /**
     * Gets rates.
     *
     * @return the rates
     */
    public List<CurrencyRateDto> getRates() {
        return rates;
    }

    /**
     * Sets rates.
     *
     * @param rates the rates
     */
    public void setRates(List<CurrencyRateDto> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DailyCurrencyRatesResponse.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("ratesTime=" + ratesTime)
                .add("rates=" + rates)
                .toString();
    }
}
