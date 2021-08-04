package br.com.hapvida.medicalconsultation.dto;

import br.com.hapvida.medicalconsultation.constraint.annotation.ValidSpecies;
import br.com.hapvida.medicalconsultation.enuns.SpeciesEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class AnimalRequestDTO {

    @NotNull(message = "O nome do animal é obrigatório")
    private String name;

    @NotNull(message = "A espécie é obrigatório")
    @ValidSpecies
    private Integer species;

    @NotNull(message = "A raça do animal é obrigatório")
    private String breed;

    @NotNull(message = "A idade do animal é obrigatório")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
}
