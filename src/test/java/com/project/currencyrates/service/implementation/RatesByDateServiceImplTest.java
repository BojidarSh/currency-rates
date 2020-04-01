package com.project.currencyrates.service.implementation;

import com.project.currencyrates.configuration.AppConfig;
import com.project.currencyrates.exception.MethodConsumptionException;
import com.project.currencyrates.model.daily.DailyCurrencyRatesResponse;
import com.project.currencyrates.service.template.RatesByDateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@DisplayName("Testing RatesByDateServiceImplTest")
class RatesByDateServiceImplTest {

    private static Logger logger = LoggerFactory.getLogger(RatesByDateServiceImplTest.class);

    @Autowired
    private RatesByDateService ratesByDateService;

    @DisplayName("Testing method rates(Date ratesDate, String... currencies)")
    @Test
    void rates() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 11, 16);
        Date testDate = calendar.getTime();

        DailyCurrencyRatesResponse response = ratesByDateService.rates(testDate, "BGN", "USD");
        logger.info("Currency exchange for rates from ECB for date {} are: {}", testDate, response);

        assertNotNull(response);
        assertNotNull(response.getTitle());
        assertNotNull(response.getRatesTime());
        assertEquals("ECB reference exchange rates", response.getTitle());
        assertNotNull(response.getRates());
        assertNotNull(response.getRates().get(0));
        assertEquals("BGN", response.getRates().get(0).getCurrency());
    }

    @DisplayName("Testing method rates(Date ratesDate, String... currencies) for expected MethodConsumptionException")
    @Test
    void rates2() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 11, 01);
        Date testDate = calendar.getTime();

        assertThrows(MethodConsumptionException.class, () -> {
            ratesByDateService.rates(testDate, "BGN", "USD");
        });
    }
}