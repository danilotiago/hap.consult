package br.com.hapvida.medicalconsultation.domain;

import br.com.hapvida.medicalconsultation.enuns.ConsultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consult {

    private Integer id;

    private LocalDateTime date;

    private ConsultEnum status;

    private Animal animal;

    private Veterinary veterinary;

    private LocalDateTime createdAt;

}
