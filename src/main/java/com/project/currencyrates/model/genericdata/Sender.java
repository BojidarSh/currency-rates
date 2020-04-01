package com.project.currencyrates.model.genericdata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.StringJoiner;

/**
 * The type Sender. It is a representation of XML element of the XML which the consumed web method returns.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Sender {

    @XmlAttribute
    private String id;

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

    @Override
    public String toString() {
        return new StringJoiner(", ", Sender.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .toString();
    }
}
