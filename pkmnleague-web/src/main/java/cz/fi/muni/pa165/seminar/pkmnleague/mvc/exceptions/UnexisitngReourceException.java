package cz.fi.muni.pa165.seminar.pkmnleague.mvc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author dhanak @domhanak on 12/16/15.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="The requested resource was not found")
public class UnexisitngReourceException extends RuntimeException{
}
