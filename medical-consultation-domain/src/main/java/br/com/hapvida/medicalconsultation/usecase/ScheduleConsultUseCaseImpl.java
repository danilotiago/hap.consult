package br.com.hapvida.medicalconsultation.usecase;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.domain.Consult;
import br.com.hapvida.medicalconsultation.domain.Veterinary;
import br.com.hapvida.medicalconsultation.exceptions.BusinessException;
import br.com.hapvida.medicalconsultation.messages.ErrorMessages;
import br.com.hapvida.medicalconsultation.ports.persistence.AnimalPersistence;
import br.com.hapvida.medicalconsultation.ports.persistence.ConsultPersistence;
import br.com.hapvida.medicalconsultation.ports.persistence.VeterinaryPersistence;
import br.com.hapvida.medicalconsultation.ports.usecase.ScheduleConsultUseCase;
import br.com.hapvida.medicalconsultation.services.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduleConsultUseCaseImpl implements ScheduleConsultUseCase {

    @Autowired
    private ScheduledService scheduledService;

    @Autowired
    private AnimalPersistence animalPersistence;

    @Autowired
    private VeterinaryPersistence veterinaryPersistence;

    @Autowired
    private ConsultPersistence consultPersistence;

    @Override
    public Consult schedule(Integer animalId, Integer veterinaryId, LocalDateTime date) {
        Animal animal = this.animalPersistence.get(animalId);
        Veterinary veterinary = this.veterinaryPersistence.get(veterinaryId);

        Consult consult = this.scheduledService.scheduled(animal, veterinary, date);

        if (this.consultPersistence.existsBy(animalId, veterinaryId, consult.getDate())) {
            throw new BusinessException(ErrorMessages.CONSULT_EXISTS);
        }

        consult = this.consultPersistence.schedule(consult);

        return consult;
    }
}
