package br.com.hapvida.medicalconsultation.ports.usecase;

import br.com.hapvida.medicalconsultation.domain.Consult;

public interface CancelConsultUseCase {

    public void cancel(Integer consultId);
}
