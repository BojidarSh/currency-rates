package com.project.currencyrates.util;

public interface AppConstants {

    interface Common {

        String PARAM_SEPARATOR = "+";
        String UNAVAILABLE = "unavailable";
        String DEFAULT_CURRENCY = "BGN";
        String DATE_FORMAT = "yyyy-MM-dd";
    }

    interface Endpoints {
        String DAILY = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
        String RATES = "https://sdw-wsrest.ecb.europa.eu/service/data/EXR/D.{currencies}.EUR.SP00.A?startPeriod={startPeriod}&endPeriod={endPeriod}";
    }

    interface Api {
        String PATH = "/api/v1/";
        String METHOD_DAILY_RATES = "daily";
        String METHOD_RATES = "rates";
    }

    interface Namespaces {
        String GESMES = "http://www.gesmes.org/xml/2002-08-01";
        String ECB_MAIN = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref";

        String MESSAGE = "http://www.sdmx.org/resources/sdmxml/schemas/v2_1/message";
        String GENERIC = "http://www.sdmx.org/resources/sdmxml/schemas/v2_1/data/generic";
    }

    interface XMLKeys {
        String CURRENCY = "CURRENCY";
    }
}
