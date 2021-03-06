package com.project.currencyrates.model.common.builder;

import com.project.currencyrates.model.common.ExceptionResponse;

import java.sql.Timestamp;
import java.util.List;

/**
 * The type Exception response.
 */
public class ExceptionResponseBuilder {

    private List<String> errorMessages;
    private String requestedURI;
    private Timestamp timestamp;

    /**
     * Error messages exception response builder.
     *
     * @param errorMessages the error messages
     * @return the exception response builder
     */
    public ExceptionResponseBuilder errorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
        return this;
    }

    /**
     * Requested uri exception response builder.
     *
     * @param requestedURI the requested uri
     * @return the exception response builder
     */
    public ExceptionResponseBuilder requestedURI(String requestedURI) {
        this.requestedURI = requestedURI;
        return this;
    }

    /**
     * Timestamp exception response builder.
     *
     * @param timestamp the timestamp
     * @return the exception response builder
     */
    public ExceptionResponseBuilder timestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Build exception response.
     *
     * @return the exception response
     */
    public ExceptionResponse build() {

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setErrorMessages(this.errorMessages);
        exceptionResponse.setRequestedURI(this.requestedURI);
        exceptionResponse.setTimestamp(this.timestamp);

        return exceptionResponse;
    }
}
