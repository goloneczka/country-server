package server.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import server.domain.service.error.ErrorResponse;
import server.domain.service.error.MappingError;
import server.domain.service.error.RestTemplateError;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(RestTemplateError.class)
    public ResponseEntity<ErrorResponse> handleRestTemplateError(RestTemplateError e, WebRequest webRequest) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getErrorMessages()));
    }

    @ExceptionHandler(MappingError.class)
    public ResponseEntity<ErrorResponse> handleMappingError(RestTemplateError e, WebRequest webRequest) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getErrorMessages()));
    }
}
