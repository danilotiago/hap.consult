package br.com.hapvida.medicalconsultation.exceptions;

import br.com.hapvida.medicalconsultation.errors.StandardError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> entityNotFoundException(EntityNotFoundException ex, WebRequest request) {

        String title = "Recurso não encontrado";
        long timestamps = System.currentTimeMillis();
        HttpStatus status = HttpStatus.NOT_FOUND;
        HttpHeaders headers = new HttpHeaders();
        StandardError body = new StandardError(status.value(), timestamps, title, ex.getMessage(), null);

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
}
