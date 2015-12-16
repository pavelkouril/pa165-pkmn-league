package cz.fi.muni.pa165.seminar.pkmnleague.mvc;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author dhanak @domhanak on 12/16/15.
 */
@XmlRootElement
public class RestErrors {

    private List<String> errors;

    public RestErrors() {
    }

    public RestErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
