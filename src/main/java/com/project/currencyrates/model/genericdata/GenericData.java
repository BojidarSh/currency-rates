package com.project.currencyrates.model.genericdata;

import com.project.currencyrates.util.AppConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.StringJoiner;

/**
 * The type Generic data. It holds {@link Header} and {@link DataSet}. It is a representation of the root XML element of the XML which the consumed web method returns.
 */
@XmlRootElement(name = "GenericData", namespace = AppConstants.Namespaces.MESSAGE)
@XmlAccessorType(XmlAccessType.FIELD)
public class GenericData {

    @XmlElement(name = "Header", namespace = AppConstants.Namespaces.MESSAGE)
    private Header header;

    @XmlElement(name = "DataSet", namespace = AppConstants.Namespaces.MESSAGE)
    private DataSet dataSet;

    /**
     * Gets header.
     *
     * @return the header
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets header.
     *
     * @param header the header
     */
    public void setHeader(Header header) {
        this.header = header;
    }

    /**
     * Gets data set.
     *
     * @return the data set
     */
    public DataSet getDataSet() {
        return dataSet;
    }

    /**
     * Sets data set.
     *
     * @param dataSet the data set
     */
    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GenericData.class.getSimpleName() + "[", "]")
                .add("header=" + header)
                .add("dataSet=" + dataSet)
                .toString();
    }
}
