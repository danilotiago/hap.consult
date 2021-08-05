package br.com.hapvida.medicalconsultation.entity;

import br.com.hapvida.medicalconsultation.enuns.ConsultEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "consults")
public class ConsultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "consult_date")
    private LocalDateTime date;

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
