package br.com.hapvida.medicalconsultation.ports.persistence;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.domain.Consult;

import java.time.LocalDate;
import java.util.List;

public interface ConsultPersistence {

    Consult get(Integer consultId);

    Boolean existsBy(Integer animalId, Integer veterinaryId, LocalDate date);

    Consult schedule(Consult consult);

    Consult cancel(Consult consult);
}
