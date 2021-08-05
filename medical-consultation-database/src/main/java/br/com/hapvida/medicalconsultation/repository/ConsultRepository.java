package br.com.hapvida.medicalconsultation.repository;

import br.com.hapvida.medicalconsultation.entity.AnimalEntity;
import br.com.hapvida.medicalconsultation.entity.ConsultEntity;
import br.com.hapvida.medicalconsultation.entity.VeterinaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ConsultRepository extends JpaRepository<ConsultEntity, Integer> {

    Boolean existsConsultEntityByVeterinaryAndAnimalAndDate(VeterinaryEntity veterinary, AnimalEntity animal, LocalDate date);

}
