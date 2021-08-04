package br.com.hapvida.medicalconsultation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VeterinaryRequestDTO {

    @NotNull(message = "O nome do veterinario é obrigatório")
    private String name;

    private String phone;

    private String email;
}
