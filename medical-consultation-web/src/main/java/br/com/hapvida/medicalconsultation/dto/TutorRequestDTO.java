package br.com.hapvida.medicalconsultation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @NotNull(message = "O id do animal é obrigatório")
    @JsonProperty("animal_id")
    private Integer animalId;
}
