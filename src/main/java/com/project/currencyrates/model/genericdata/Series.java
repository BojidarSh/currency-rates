package com.project.currencyrates.model.genericdata;

import com.project.currencyrates.util.AppConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.StringJoiner;

/**
 * The type Series. It holds two {@link KeyValueHolder} objects and {@link Obs}. It is a representation of XML element of the XML which the consumed web method returns.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Series {

    @XmlElement(name = "SeriesKey", namespace = AppConstants.Namespaces.GENERIC)
    private KeyValueHolder seriesKey;

    @XmlElement(name = "Attributes", namespace = AppConstants.Namespaces.GENERIC)
    private KeyValueHolder attributes;

    @XmlElement(name = "Obs", namespace = AppConstants.Namespaces.GENERIC)
    private Obs obs;

    /**
     * Gets series key.
     *
     * @return the series key
     */
    public KeyValueHolder getSeriesKey() {
        return seriesKey;
    }

    /**
     * Sets series key.
     *
     * @param seriesKey the series key
     */
    public void setSeriesKey(KeyValueHolder seriesKey) {
        this.seriesKey = seriesKey;
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

    /**
     * Gets obs.
     *
     * @return the obs
     */
    public Obs getObs() {
        return obs;
    }

    /**
     * Sets obs.
     *
     * @param obs the obs
     */
    public void setObs(Obs obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Series.class.getSimpleName() + "[", "]")
                .add("seriesKey=" + seriesKey)
                .add("attributes=" + attributes)
                .add("obs=" + obs)
                .toString();
    }
}
