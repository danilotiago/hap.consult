package br.com.hapvida.medicalconsultation.dto;

import br.com.hapvida.medicalconsultation.enuns.SpeciesEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AnimalResponseDTO {

    private Integer id;

    private String name;

    private SpeciesResponseDTO species;

    private String breed;

    private LocalDate birthDate;

    private List<TutorResponseDTO> tutors;

    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
