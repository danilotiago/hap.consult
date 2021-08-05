package br.com.hapvida.medicalconsultation.dto;

import br.com.hapvida.medicalconsultation.constraint.annotation.ValidSpecies;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class ScheduleRequestDTO {

    @NotNull(message = "O id do animal é obrigatório")
    @JsonProperty("animal_id")
    private Integer animalId;

    @NotNull(message = "O id do veterinário é obrigatório")
    @JsonProperty("veterinary_id")
    private Integer veterinaryId;
}
