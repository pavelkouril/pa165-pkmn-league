package cz.fi.muni.pa165.seminar.pkmnleague.mvc.controllers;

import cz.fi.muni.pa165.seminar.pkmnleague.mvc.RestErrors;
import cz.fi.muni.pa165.seminar.pkmnleague.mvc.exceptions.ExistingResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;

/**
 * @author dhanak @domhanak on 12/16/15.
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    RestErrors handleException(ExistingResourceException ex) {
        RestErrors apiError = new RestErrors();
        apiError.setErrors(Arrays.asList("the requested resource already exists"));
        return apiError;
    }
}
