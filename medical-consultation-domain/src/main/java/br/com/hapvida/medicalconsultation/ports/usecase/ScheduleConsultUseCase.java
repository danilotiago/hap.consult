package br.com.hapvida.medicalconsultation.ports.usecase;

import br.com.hapvida.medicalconsultation.domain.Consult;

import java.time.LocalDateTime;

public interface ScheduleConsultUseCase {

    public Consult schedule(Integer animalId, Integer veterinaryId, LocalDateTime date);
}
