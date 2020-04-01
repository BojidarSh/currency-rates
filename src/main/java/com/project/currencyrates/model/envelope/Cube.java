package com.project.currencyrates.model.envelope;

import com.project.currencyrates.util.AppConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.StringJoiner;

/**
 * The type Cube. It holds the {@link CurrencyRates}. It is a representation of XML element of the XML which the consumed web method returns.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Cube {

    @XmlElement(name = "Cube", namespace = AppConstants.Namespaces.ECB_MAIN)
    private CurrencyRates cube;

    /**
     * Gets cube.
     *
     * @return the cube
     */
    public CurrencyRates getCube() {
        return cube;
    }

    /**
     * Sets cube.
     *
     * @param cube the cube
     */
    public void setCube(CurrencyRates cube) {
        this.cube = cube;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cube.class.getSimpleName() + "[", "]")
                .add("cube=" + cube)
                .toString();
    }
}
