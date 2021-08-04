package br.com.hapvida.medicalconsultation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SpeciesResponseDTO {

    private Integer code;
    private String name;
}
