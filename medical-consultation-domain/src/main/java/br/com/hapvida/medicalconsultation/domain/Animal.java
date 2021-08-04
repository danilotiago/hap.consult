package br.com.hapvida.medicalconsultation.domain;

import br.com.hapvida.medicalconsultation.enuns.SpeciesEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    private Integer id;

    private String name;

    private SpeciesEnum species;

    private String breed;

    private LocalDate birthDate;

    private List<Tutor> tutors;

    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
