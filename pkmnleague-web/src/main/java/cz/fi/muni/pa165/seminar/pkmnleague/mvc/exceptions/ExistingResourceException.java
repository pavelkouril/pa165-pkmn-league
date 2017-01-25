package cz.fi.muni.pa165.seminar.pkmnleague.mvc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception used when resource already exists.
 *
 * @author dhanak @domhanak on 12/16/15.
 */
@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason="The resource already exists")
public class ExistingResourceException  extends RuntimeException {

    public ExistingResourceException() {
    }

    public ExistingResourceException(String message) {
        super(message);
    }

    public ExistingResourceException(String message, Throwable cause) {
        super(message, cause);
    }
}
