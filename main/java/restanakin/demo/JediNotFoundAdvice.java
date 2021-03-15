package restanakin.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class JediNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(JediNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notFound(JediNotFoundException ex) {
        return ex.getMessage();
    }
}
