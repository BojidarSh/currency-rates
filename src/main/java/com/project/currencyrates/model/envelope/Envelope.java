package com.project.currencyrates.model.envelope;

import com.project.currencyrates.util.AppConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.StringJoiner;

/**
 * The type Envelope. It holds {@link Sender} and {@link Cube}. It is a representation of the root XML element of the XML which the consumed web method returns.
 */
@XmlRootElement(name = "Envelope", namespace = AppConstants.Namespaces.GESMES)
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {

    @XmlElement(name = "subject", namespace = AppConstants.Namespaces.GESMES)
    private String subject;

    @XmlElement(name = "Sender", namespace = AppConstants.Namespaces.GESMES)
    private Sender sender;

    @XmlElement(name = "Cube", namespace = AppConstants.Namespaces.ECB_MAIN)
    private Cube cube;

    /**
     * Gets subject.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

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

    /**
     * Gets cube.
     *
     * @return the cube
     */
    public Cube getCube() {
        return cube;
    }

    /**
     * Sets cube.
     *
     * @param cube the cube
     */
    public void setCube(Cube cube) {
        this.cube = cube;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Envelope.class.getSimpleName() + "[", "]")
                .add("subject='" + subject + "'")
                .add("sender=" + sender)
                .add("cube=" + cube)
                .toString();
    }
}
