package com.project.currencyrates.model.envelope;

import com.project.currencyrates.util.AppConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.StringJoiner;

/**
 * The type Sender. It is a representation of XML element of the XML which the consumed web method returns.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Sender {

    @XmlElement(name = "name", namespace = AppConstants.Namespaces.GESMES)
    private String name;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Sender.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
