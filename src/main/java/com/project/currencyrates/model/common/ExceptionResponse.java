package com.project.currencyrates.model.common;

import java.sql.Timestamp;
import java.util.List;
import java.util.StringJoiner;

/**
 * The type Exception response.
 */
public class ExceptionResponse {

    private List<String> errorMessages;
    private String requestedURI;
    private Timestamp timestamp;

    /**
     * Gets error messages.
     *
     * @return the error messages
     */
    public List<String> getErrorMessages() {
        return errorMessages;
    }

    /**
     * Sets error messages.
     *
     * @param errorMessages the error messages
     */
    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    /**
     * Gets requested uri.
     *
     * @return the requested uri
     */
    public String getRequestedURI() {
        return requestedURI;
    }

    /**
     * Sets requested uri.
     *
     * @param requestedURI the requested uri
     */
    public void setRequestedURI(final String requestedURI) {
        this.requestedURI = requestedURI;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExceptionResponse.class.getSimpleName() + "[", "]")
                .add("errorMessages=" + errorMessages)
                .add("requestedURI='" + requestedURI + "'")
                .add("timestamp=" + timestamp)
                .toString();
    }
}
