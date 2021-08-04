package br.com.hapvida.medicalconsultation.usecase;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.exceptions.BusinessException;
import br.com.hapvida.medicalconsultation.messages.ErrorMessages;
import br.com.hapvida.medicalconsultation.ports.persistence.AnimalPersistence;
import br.com.hapvida.medicalconsultation.ports.usecase.AnimalManagerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Objects.isNull;

@Component
public class AnimalManagerUseCaseImpl implements AnimalManagerUseCase {

    @Autowired
    private AnimalPersistence persistence;

    @Override
    public Animal get(Integer code) {
        if (isNull(code)) {
            throw new BusinessException(ErrorMessages.ANIMAL_CODE_REQUIRED);
        }
        return this.persistence.get(code);
    }

    @Override
    public List<Animal> list() {
        return this.persistence.list();
    }

    @Override
    public List<Animal> listWithTrashed() {
        return this.persistence.listWithTrashed();
    }

    @Override
    public List<Animal> listOnlyTrashed() {
        return this.persistence.listOnlyTrashed();
    }

    @Override
    public Animal save(Animal animal) {
        if (isNull(animal)) {
            throw new BusinessException(ErrorMessages.ANIMAL_REQUIRED);
        }

        if (isNull(animal.getIsActive())) {
            animal.setIsActive(Boolean.TRUE);
        }

        return this.persistence.save(animal);
    }

    @Override
    public void delete(Integer code) {
        if (isNull(code)) {
            throw new BusinessException(ErrorMessages.ANIMAL_REQUIRED);
        }

        Animal tutorFounded = this.get(code);

        if (isNull(tutorFounded)) {
            throw new BusinessException(ErrorMessages.ANIMAL_NOT_FOUND);
        }

        this.persistence.delete(tutorFounded);
    }
}
