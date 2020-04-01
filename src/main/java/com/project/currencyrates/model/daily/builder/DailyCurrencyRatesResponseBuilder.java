package com.project.currencyrates.model.daily.builder;

import com.project.currencyrates.model.daily.CurrencyRateDto;
import com.project.currencyrates.model.daily.DailyCurrencyRatesResponse;

import java.util.Date;
import java.util.List;

/**
 * The type Daily currency rates response builder. Builds {@link DailyCurrencyRatesResponse}.
 */
public class DailyCurrencyRatesResponseBuilder {

    private String title;
    private Date ratesTime;
    private List<CurrencyRateDto> rates;

    /**
     * Sets the title of the response.
     *
     * @param title the title
     * @return the daily currency rates response builder
     */
    public DailyCurrencyRatesResponseBuilder title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the time to which the rates are relevant.
     *
     * @param time the time
     * @return the daily currency rates response builder
     */
    public DailyCurrencyRatesResponseBuilder ratesTime(Date time) {
        this.ratesTime = time;
        return this;
    }

    /**
     * Sets rates.
     *
     * @param rates the rates
     * @return the daily currency rates response builder
     */
    public DailyCurrencyRatesResponseBuilder rates(List<CurrencyRateDto> rates) {
        this.rates = rates;
        return this;
    }

    /**
     * Build daily currency rates response.
     *
     * @return the daily currency rates response
     */
    public DailyCurrencyRatesResponse build() {
        DailyCurrencyRatesResponse response = new DailyCurrencyRatesResponse();

        response.setTitle(this.title);
        response.setRatesTime(this.ratesTime);
        response.setRates(this.rates);

        return response;
    }
}