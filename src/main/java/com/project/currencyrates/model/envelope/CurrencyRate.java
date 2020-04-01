package com.project.currencyrates.model.envelope;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.StringJoiner;

/**
 * The type Currency rate. It holds the currency and the rate. It is a representation of XML element of the XML which the consumed web method returns.
 */
@XmlRootElement(name = "Cube")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrencyRate {

    @XmlAttribute
    private String currency;

    @XmlAttribute
    private String rate;

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets currency.
     *
     * @param currency the currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets rate.
     *
     * @return the rate
     */
    public String getRate() {
        return rate;
    }

    /**
     * Sets rate.
     *
     * @param rate the rate
     */
    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CurrencyRate.class.getSimpleName() + "[", "]")
                .add("currency='" + currency + "'")
                .add("rate='" + rate + "'")
                .toString();
    }
}
