package com.project.currencyrates.service.implementation;

import com.project.currencyrates.exception.MethodConsumptionException;
import com.project.currencyrates.model.daily.CurrencyRateDto;
import com.project.currencyrates.model.daily.DailyCurrencyRatesResponse;
import com.project.currencyrates.model.daily.builder.DailyCurrencyRatesResponseBuilder;
import com.project.currencyrates.model.genericdata.GenericData;
import com.project.currencyrates.model.genericdata.KeyValue;
import com.project.currencyrates.model.genericdata.Series;
import com.project.currencyrates.service.template.RatesByDateService;
import com.project.currencyrates.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Rates by date service. Retrieves ECB currency daily rates for the moment of the provided date.
 */
@Service
public class RatesByDateServiceImpl implements RatesByDateService {

    private Logger logger = LoggerFactory.getLogger(RatesByDateServiceImpl.class);

    @Override
    public DailyCurrencyRatesResponse rates(Date ratesDate, String... currencies) {
        RestTemplate restTemplate = new RestTemplate();

        String METHOD_URL = populateParams(ratesDate, currencies);
        GenericData genericData = restTemplate.getForObject(METHOD_URL, GenericData.class, 200);
        logger.info("GenericData received: {}", genericData);

        if (genericData != null && genericData.getDataSet() != null &&
                genericData.getDataSet().getSeries() != null) {

            List<CurrencyRateDto> outputRates = new ArrayList<>();
            String currencyFromDate = null;

            List<Series> series = genericData.getDataSet().getSeries();

            for (int i = 0; i < series.size(); i++) {

                Series element = series.get(i);

                List<KeyValue> values = element.getSeriesKey() != null && element.getSeriesKey().getValues() != null
                        ? element.getSeriesKey().getValues() : new ArrayList<>();
                values = values.stream().filter(elementVal -> elementVal.getId().equals(AppConstants.XMLKeys.CURRENCY)).collect(Collectors.toList());
                String currency = values != null && values.size() > 0 ? values.get(0).getValue() : AppConstants.Common.UNAVAILABLE;

                String rate = element.getObs() != null && element.getObs().getObsValue() != null && element.getObs().getObsValue().getValue() != null
                        ? element.getObs().getObsValue().getValue() : AppConstants.Common.UNAVAILABLE;

                outputRates.add(new CurrencyRateDto(currency, rate));

                if (currencyFromDate == null) {
                    currencyFromDate = element.getObs() != null && element.getObs().getObsDimension() != null
                            && element.getObs().getObsDimension().getValue() != null
                            ? element.getObs().getObsDimension().getValue() : null;
                }
            }

            Date time = null;
            try {
                time = new SimpleDateFormat(AppConstants.Common.DATE_FORMAT).parse(currencyFromDate);
            } catch (ParseException e) {
                logger.error("Wrong date format {}, expected format {}.", currencyFromDate, AppConstants.Common.DATE_FORMAT);
            }

            return new DailyCurrencyRatesResponseBuilder()
                    .title("ECB reference exchange rates")
                    .ratesTime(time)
                    .rates(outputRates)
                    .build();
        }

        List<String> messages = new ArrayList<>();
        messages.add("No data received by method.");

        throw new MethodConsumptionException("No data received by method.");
    }

    private String populateParams(Date ratesDate, String... currencies) {

        String currenciesParams = new String();
        for (int i = 0; i < currencies.length; i++) {
            String param = i < currencies.length - 1 ? currencies[i] + AppConstants.Common.PARAM_SEPARATOR : currencies[i];
            currenciesParams += param;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AppConstants.Common.DATE_FORMAT);
        String dateParam = simpleDateFormat.format(ratesDate);

        return AppConstants.Endpoints.RATES
                .replace("{currencies}", currenciesParams)
                .replace("{startPeriod}", dateParam)
                .replace("{endPeriod}", dateParam);
    }
}
