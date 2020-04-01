package com.project.currencyrates.model.envelope;

import com.project.currencyrates.util.AppConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 * The type Currency rates. Holds the time to which the rates are relevant. Holds also a lisit of {@link CurrencyRate}.
 * It is a representation of XML element of the XML which the consumed web method returns.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrencyRates {

    @XmlAttribute
    private Date time;

    @XmlElement(name = "Cube", namespace = AppConstants.Namespaces.ECB_MAIN)
    private List<CurrencyRate> cube;

    /**
     * Gets time.
     *
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * Gets cube.
     *
     * @return the cube
     */
    public List<CurrencyRate> getCube() {
        return cube;
    }

    /**
     * Sets cube.
     *
     * @param cube the cube
     */
    public void setCube(List<CurrencyRate> cube) {
        this.cube = cube;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CurrencyRates.class.getSimpleName() + "[", "]")
                .add("time=" + time)
                .add("cube=" + cube)
                .toString();
    }
}
