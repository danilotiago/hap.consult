package br.com.hapvida.medicalconsultation.entity;

import br.com.hapvida.medicalconsultation.enuns.ConsultEnum;
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
@Entity(name = "consults")
public class ConsultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "consult_date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private ConsultEnum status;

    @ManyToOne
    @JoinColumn(name = "animals_id")
    private AnimalEntity animal;

    @ManyToOne
    @JoinColumn(name = "veterinarians_id")
    private VeterinaryEntity veterinary;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    private void beforePersist() {
        setCreatedAt(LocalDateTime.now());
    }
}
