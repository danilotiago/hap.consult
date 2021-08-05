package br.com.hapvida.medicalconsultation.services;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.domain.Consult;
import br.com.hapvida.medicalconsultation.domain.Veterinary;
import br.com.hapvida.medicalconsultation.enuns.ConsultEnum;
import br.com.hapvida.medicalconsultation.exceptions.BusinessException;
import br.com.hapvida.medicalconsultation.messages.ErrorMessages;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.util.Objects.isNull;

@Component
public class ScheduledService {

    public Consult scheduled(Animal animal, Veterinary veterinary) {

        if (isNull(animal)) {
            throw new BusinessException(ErrorMessages.ANIMAL_REQUIRED);
        }

        if (isNull(veterinary)) {
            throw new BusinessException(ErrorMessages.VETERINARY_REQUIRED);
        }

        if (! animal.getIsActive()) {
            throw new BusinessException(ErrorMessages.ANIMAL_INACTIVE);
        }

        if (! isNull(animal.getDeletedAt())) {
            throw new BusinessException(ErrorMessages.ANIMAL_DELETED);
        }

        if (! veterinary.getIsActive()) {
            throw new BusinessException(ErrorMessages.VETERINARY_INACTIVE);
        }

        if (! isNull(veterinary.getDeletedAt())) {
            throw new BusinessException(ErrorMessages.VETERINARY_DELETED);
        }

        Consult consult = new Consult();
        consult.setStatus(ConsultEnum.SCHEDULED);
        consult.setAnimal(animal);
        consult.setVeterinary(veterinary);
        consult.setDate(LocalDate.now());

        return consult;
    }
}
