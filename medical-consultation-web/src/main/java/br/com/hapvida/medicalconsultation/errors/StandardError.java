package br.com.hapvida.medicalconsultation.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {

    private Integer status;

    private long timestamps;

    private String title;

    private String detail;

    private List<FieldAndMessageError> errors;
}
