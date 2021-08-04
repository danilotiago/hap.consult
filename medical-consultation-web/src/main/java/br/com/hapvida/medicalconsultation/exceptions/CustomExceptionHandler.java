package br.com.hapvida.medicalconsultation.exceptions;

import br.com.hapvida.medicalconsultation.exceptions.errors.GenericError;
import br.com.hapvida.medicalconsultation.exceptions.errors.ValidationError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    private static final String VALIDATION_ERROR = "Erro de validação";

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> entityNotFoundException(EntityNotFoundException ex, WebRequest request) {

        GenericError body = new GenericError(LocalDateTime.now().toString(), HttpStatus.NOT_FOUND.value(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> apply(MethodArgumentNotValidException ex) {
        ValidationError err = new ValidationError(LocalDateTime.now().toString(), HttpStatus.UNPROCESSABLE_ENTITY.value(), VALIDATION_ERROR);

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            err.addError(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
    }
}
