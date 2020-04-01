package com.project.currencyrates.service.implementation;

import com.project.currencyrates.exception.MethodConsumptionException;
import com.project.currencyrates.model.daily.CurrencyRateDto;
import com.project.currencyrates.model.daily.DailyCurrencyRatesResponse;
import com.project.currencyrates.model.daily.builder.DailyCurrencyRatesResponseBuilder;
import com.project.currencyrates.model.envelope.CurrencyRate;
import com.project.currencyrates.model.envelope.Envelope;
import com.project.currencyrates.service.template.DailyRatesService;
import com.project.currencyrates.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Daily rates service. Retrieves current ECB currency daily rates.
 */
@Service
public class DailyRatesServiceImpl implements DailyRatesService {

    private Logger logger = LoggerFactory.getLogger(DailyRatesServiceImpl.class);

    @Override
    public DailyCurrencyRatesResponse daily() {

        RestTemplate restTemplate = new RestTemplate();

        Envelope envelope = restTemplate.getForObject(AppConstants.Endpoints.DAILY, Envelope.class, 200);
        logger.info("Envelope received: {}", envelope);

        if (envelope != null) {
            Date time = new Date();
            List<CurrencyRate> inputRates = new ArrayList();
            if (envelope.getCube() != null &&
                    envelope.getCube().getCube() != null) {

                if (envelope.getCube().getCube().getTime() != null) {
                    time = envelope.getCube().getCube().getTime();
                }

                if (envelope.getCube().getCube().getCube() != null) {
                    inputRates = envelope.getCube().getCube().getCube();
                }
            }

            List<CurrencyRateDto> outputRates = new ArrayList<>();
            inputRates.forEach(element -> outputRates.add(new CurrencyRateDto(element.getCurrency(), element.getRate())));

            return new DailyCurrencyRatesResponseBuilder()
                    .title("Daily ECB reference exchange rates")
                    .ratesTime(time)
                    .rates(outputRates)
                    .build();
        }

        throw new MethodConsumptionException("No data received by method.");
    }
}