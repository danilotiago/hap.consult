package br.com.hapvida.medicalconsultation.entity;

import br.com.hapvida.medicalconsultation.enuns.SpeciesEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SQLDelete(sql = "UPDATE animals SET deleted_at = NOW() WHERE id = ?")
@Entity(name = "animals")
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private SpeciesEnum species;

    private String breed;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "animal")
    private List<TutorEntity> tutors = new ArrayList<>();

    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @PrePersist
    private void beforePersist() {
        setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    private void beforeUpdate() {
        setUpdatedAt(LocalDateTime.now());
    }
}
