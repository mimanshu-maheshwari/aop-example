package mm.vivarta.av.aspect;

import mm.vivarta.av.dto.ErrorMessage;
import mm.vivarta.av.exception.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {UserException.class})
  protected ResponseEntity<ErrorMessage> handleException(UserException exception, WebRequest request) {
    return ResponseEntity.badRequest().body(new ErrorMessage(exception.getMessage(), request.getParameterMap()));
  }

}
