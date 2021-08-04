package br.com.hapvida.medicalconsultation.exceptions.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FieldMessageError {

    private String field;
    private String message;
}
