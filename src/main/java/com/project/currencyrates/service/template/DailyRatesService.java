package com.project.currencyrates.service.template;

import com.project.currencyrates.model.daily.DailyCurrencyRatesResponse;

/**
 * The interface Daily rates service. Provides a template for DailyRatesService.
 */
public interface DailyRatesService {

    /**
     * Gets current currency rates.
     *
     * @return the daily currency rates response
     */
    DailyCurrencyRatesResponse daily();
}