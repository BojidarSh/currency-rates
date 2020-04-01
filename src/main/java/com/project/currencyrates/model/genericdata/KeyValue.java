package com.project.currencyrates.model.genericdata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.StringJoiner;

/**
 * The type Key value. It is a representation of XML element of the XML which the consumed web method returns.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class KeyValue {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String value;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

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
        return new StringJoiner(", ", KeyValue.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("value='" + value + "'")
                .toString();
    }
}
