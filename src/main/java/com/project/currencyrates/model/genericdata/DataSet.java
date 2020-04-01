package com.project.currencyrates.model.genericdata;

import com.project.currencyrates.util.AppConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 * The type Data set. It holds list of {@link Series}. It holds the date from which the request was made.
 * It is a representation of XML element of the XML which the consumed web method returns.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataSet {

    @XmlAttribute
    private Date validFromDate;

    @XmlElement(name = "Series", namespace = AppConstants.Namespaces.GENERIC)
    private List<Series> series;

    /**
     * Gets valid from date.
     *
     * @return the valid from date
     */
    public Date getValidFromDate() {
        return validFromDate;
    }

    /**
     * Sets valid from date.
     *
     * @param validFromDate the valid from date
     */
    public void setValidFromDate(Date validFromDate) {
        this.validFromDate = validFromDate;
    }

    /**
     * Gets series.
     *
     * @return the series
     */
    public List<Series> getSeries() {
        return series;
    }

    /**
     * Sets series.
     *
     * @param series the series
     */
    public void setSeries(List<Series> series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DataSet.class.getSimpleName() + "[", "]")
                .add("validFromDate=" + validFromDate)
                .add("series=" + series)
                .toString();
    }
}
