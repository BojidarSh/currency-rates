package com.project.currencyrates.model.genericdata;

import com.project.currencyrates.util.AppConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.StringJoiner;

/**
 * The type Header. It holds {@link Sender}. It is a representation of XML element of the XML which the consumed web method returns.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Header {

    @XmlElement(name = "Sender", namespace = AppConstants.Namespaces.MESSAGE)
    private Sender sender;

    /**
     * Gets sender.
     *
     * @return the sender
     */
    public Sender getSender() {
        return sender;
    }

    /**
     * Sets sender.
     *
     * @param sender the sender
     */
    public void setSender(Sender sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Header.class.getSimpleName() + "[", "]")
                .add("sender=" + sender)
                .toString();
    }
}
