package com.project.currencyrates.model.genericdata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.StringJoiner;

/**
 * The type Value. It is a representation of XML element of the XML which the consumed web method returns.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Value {

    @XmlAttribute
    private String value;

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Value.class.getSimpleName() + "[", "]")
                .add("value='" + value + "'")
                .toString();
    }
}