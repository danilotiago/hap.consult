package br.com.hapvida.medicalconsultation.exceptions.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericError {

    private String timestamp;
    private Integer status;
    private String message;
}
