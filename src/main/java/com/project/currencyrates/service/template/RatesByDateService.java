package com.project.currencyrates.service.template;

import com.project.currencyrates.model.daily.DailyCurrencyRatesResponse;

import java.util.Date;

/**
 * The interface Рates by date service. Provides a template for RatesByDateService.
 */
public interface RatesByDateService {

    /**
     * Gets currency rates, relative to the provided date.
     *
     * @return the daily currency rates response
     */
    DailyCurrencyRatesResponse rates(Date ratesDate, String... currencies);
}