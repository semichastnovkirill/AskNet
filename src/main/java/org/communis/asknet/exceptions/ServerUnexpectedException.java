package org.communis.asknet.exceptions;


import org.communis.asknet.exceptions.error.ErrorInformation;

public class ServerUnexpectedException extends ServerException {

    public ServerUnexpectedException(ErrorInformation errorInformation) {
        super(errorInformation);
    }

    public ServerUnexpectedException(ErrorInformation errorInformation, Throwable cause) {
        super(errorInformation, cause);
    }
}
