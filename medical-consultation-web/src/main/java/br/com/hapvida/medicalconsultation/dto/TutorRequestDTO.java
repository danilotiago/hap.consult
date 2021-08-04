package br.com.hapvida.medicalconsultation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TutorRequestDTO {

    @NotNull(message = "O nome do tutor é obrigatório")
    private String name;

    private String phone;

    private String email;
}
