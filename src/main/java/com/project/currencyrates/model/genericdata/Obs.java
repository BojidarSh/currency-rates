package com.project.currencyrates.model.genericdata;

import com.project.currencyrates.util.AppConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.StringJoiner;

/**
 * The type Obs. It holds the date to which the currency rate is relevant.
 * It holds two {@link Value} objects and {@link KeyValueHolder}. It is a representation of XML element of the XML which the consumed web method returns.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Obs {

    @XmlElement(name = "ObsDimension", namespace = AppConstants.Namespaces.GENERIC)
    private Value obsDimension;

    @XmlElement(name = "ObsValue", namespace = AppConstants.Namespaces.GENERIC)
    private Value obsValue;

    /**
     * The Attributes.
     */
    @XmlElement(name = "Attributes", namespace = AppConstants.Namespaces.GENERIC)
    public KeyValueHolder attributes;

    /**
     * Gets obs dimension.
     *
     * @return the obs dimension
     */
    public Value getObsDimension() {
        return obsDimension;
    }

    /**
     * Sets obs dimension.
     *
     * @param obsDimension the obs dimension
     */
    public void setObsDimension(Value obsDimension) {
        this.obsDimension = obsDimension;
    }

    /**
     * Gets obs value.
     *
     * @return the obs value
     */
    public Value getObsValue() {
        return obsValue;
    }

    /**
     * Sets obs value.
     *
     * @param obsValue the obs value
     */
    public void setObsValue(Value obsValue) {
        this.obsValue = obsValue;
    }

    /**
     * Gets attributes.
     *
     * @return the attributes
     */
    public KeyValueHolder getAttributes() {
        return attributes;
    }

    /**
     * Sets attributes.
     *
     * @param attributes the attributes
     */
    public void setAttributes(KeyValueHolder attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Obs.class.getSimpleName() + "[", "]")
                .add("obsDimension=" + obsDimension)
                .add("obsValue=" + obsValue)
                .add("attributes=" + attributes)
                .toString();
    }
}
