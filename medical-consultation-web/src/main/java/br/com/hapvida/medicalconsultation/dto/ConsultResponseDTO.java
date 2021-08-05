package br.com.hapvida.medicalconsultation.dto;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.domain.Veterinary;
import br.com.hapvida.medicalconsultation.enuns.ConsultEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class ConsultResponseDTO {

    private Integer id;

    private LocalDate date;

    private ConsultEnum status;

    private Animal animal;

    private Veterinary veterinary;
}
