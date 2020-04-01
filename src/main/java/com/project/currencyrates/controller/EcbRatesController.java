package com.project.currencyrates.controller;

import com.project.currencyrates.model.daily.DailyCurrencyRatesResponse;
import com.project.currencyrates.service.template.DailyRatesService;
import com.project.currencyrates.service.template.RatesByDateService;
import com.project.currencyrates.util.AppConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Date;

@RestController
@RequestMapping(AppConstants.Api.PATH)
@Validated
public class EcbRatesController {

    private final DailyRatesService dailyRatesService;
    private final RatesByDateService ratesByDateService;

    public EcbRatesController(DailyRatesService dailyRatesService, RatesByDateService ratesByDateService) {
        this.dailyRatesService = dailyRatesService;
        this.ratesByDateService = ratesByDateService;
    }

    @GetMapping(AppConstants.Api.METHOD_DAILY_RATES)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    DailyCurrencyRatesResponse daily() {

        return dailyRatesService.daily();
    }

    @GetMapping(AppConstants.Api.METHOD_RATES)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    DailyCurrencyRatesResponse rates(@RequestParam @DateTimeFormat(pattern = AppConstants.Common.DATE_FORMAT) @Valid Date ratesDate,
                                     @Valid @Size(max = 3) @RequestParam(defaultValue = AppConstants.Common.DEFAULT_CURRENCY) String... currencies) {

        return ratesByDateService.rates(ratesDate, currencies);
    }
}