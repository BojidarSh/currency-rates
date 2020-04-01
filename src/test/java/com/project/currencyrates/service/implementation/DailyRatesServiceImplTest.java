package com.project.currencyrates.service.implementation;

import com.project.currencyrates.configuration.AppConfig;
import com.project.currencyrates.model.daily.DailyCurrencyRatesResponse;
import com.project.currencyrates.service.template.DailyRatesService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@DisplayName("Testing DailyRatesServiceImpl")
@SpringBootTest
class DailyRatesServiceImplTest {

    private static Logger logger = LoggerFactory.getLogger(DailyRatesServiceImplTest.class);

    @Autowired
    private DailyRatesService dailyRatesService;

    @DisplayName("Testing method daily()")
    @Test
    void daily() {

        DailyCurrencyRatesResponse response = dailyRatesService.daily();
        logger.info("Last currency exchange rates from ECB are: {}", response);

        assertNotNull(response);
        assertNotNull(response.getRates());
        assertNotNull(response.getRates().get(0));
        assertEquals("USD", response.getRates().get(0).getCurrency());
    }
}