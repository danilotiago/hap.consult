package br.com.hapvida.medicalconsultation.usecase;

import br.com.hapvida.medicalconsultation.domain.Consult;
import br.com.hapvida.medicalconsultation.ports.persistence.ConsultPersistence;
import br.com.hapvida.medicalconsultation.ports.usecase.CancelConsultUseCase;
import br.com.hapvida.medicalconsultation.services.CancelService;
import org.springframework.beans.factory.annotation.Autowired;

public class CancelConsultUseCaseImpl implements CancelConsultUseCase {

    @Autowired
    private CancelService cancelService;

    @Autowired
    private ConsultPersistence consultPersistence;

    @Override
    public void cancel(Integer consultId) {
        Consult consult = this.consultPersistence.get(consultId);

        this.cancelService.cancel(consult);
    }
}
