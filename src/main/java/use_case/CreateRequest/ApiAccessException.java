package use_case.CreateRequest;

import entities.factories.service_request.DataUnavailableException;

import javax.xml.crypto.Data;

/**
 * Exception to be thrown whenever there is an issue accessing the API.
 */
public class ApiAccessException extends DataUnavailableException {

    /**
     * Create a ApiAccessException.
     */
    public ApiAccessException() {
        super();
    }
}