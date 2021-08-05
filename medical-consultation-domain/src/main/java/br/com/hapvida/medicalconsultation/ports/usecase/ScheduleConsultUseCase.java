package br.com.hapvida.medicalconsultation.ports.usecase;

import br.com.hapvida.medicalconsultation.domain.Consult;

public interface ScheduleConsultUseCase {

    public Consult schedule(Integer animalId, Integer veterinaryId);
}
