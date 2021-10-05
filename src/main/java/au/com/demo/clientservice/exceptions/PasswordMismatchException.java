package au.com.demo.clientservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class PasswordMismatchException extends RuntimeException {
    private static final long serialVersionUID = -3468680283639136687L;

    public PasswordMismatchException(String exception) {
        super(exception);
    }
}
