package br.com.hapvida.medicalconsultation.ports.persistence;

import br.com.hapvida.medicalconsultation.domain.Consult;

import java.time.LocalDateTime;

public interface ConsultPersistence {

    Consult get(Integer consultId);

    Boolean existsBy(Integer animalId, Integer veterinaryId, LocalDateTime date);

    Consult schedule(Consult consult);

    Consult cancel(Consult consult);
}
