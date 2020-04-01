package com.project.currencyrates.model.genericdata;

import com.project.currencyrates.util.AppConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.StringJoiner;

/**
 * The type Key value holder. It holds {@link KeyValue}. It is a representation of XML element of the XML which the consumed web method returns.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class KeyValueHolder {

    @XmlElement(name = "Value", namespace = AppConstants.Namespaces.GENERIC)
    private List<KeyValue> values;

    /**
     * Gets values.
     *
     * @return the values
     */
    public List<KeyValue> getValues() {
        return values;
    }

    /**
     * Sets values.
     *
     * @param values the values
     */
    public void setValues(List<KeyValue> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", KeyValueHolder.class.getSimpleName() + "[", "]")
                .add("values=" + values)
                .toString();
    }
}
