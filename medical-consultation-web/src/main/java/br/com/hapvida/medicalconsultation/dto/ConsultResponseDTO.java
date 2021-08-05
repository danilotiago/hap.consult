package br.com.hapvida.medicalconsultation.dto;

import br.com.hapvida.medicalconsultation.enuns.ConsultEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ConsultResponseDTO {

    private Integer id;

    private LocalDateTime date;

    private ConsultEnum status;

    private AnimalResponseDTO animal;

    private VeterinaryResponseDTO veterinary;
}
