package org.communis.asknet.exceptions;


import org.communis.asknet.exceptions.error.ErrorInformation;

public class NotFoundException extends ServerException {
    public NotFoundException(ErrorInformation errorInformation) {
        super(errorInformation);
    }
}
