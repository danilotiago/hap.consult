package br.com.hapvida.medicalconsultation.usecase;

import br.com.hapvida.medicalconsultation.domain.Veterinary;
import br.com.hapvida.medicalconsultation.exceptions.BusinessException;
import br.com.hapvida.medicalconsultation.messages.ErrorMessages;
import br.com.hapvida.medicalconsultation.ports.persistence.VeterinaryPersistence;
import br.com.hapvida.medicalconsultation.ports.usecase.VeterinaryManagerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Objects.isNull;

@Component
public class VeterinaryManagerUseCaseImpl implements VeterinaryManagerUseCase {

    @Autowired
    private VeterinaryPersistence persistence;

    @Override
    public Veterinary get(Integer code) {
        if (isNull(code)) {
            throw new BusinessException(ErrorMessages.VETERINARY_CODE_REQUIRED);
        }
        return this.persistence.get(code);
    }

    @Override
    public List<Veterinary> list() {
        return this.persistence.list();
    }

    @Override
    public List<Veterinary> listWithTrashed() {
        return this.persistence.listWithTrashed();
    }

    @Override
    public List<Veterinary> listOnlyTrashed() {
        return this.persistence.listOnlyTrashed();
    }

    @Override
    public Veterinary save(Veterinary category) {
        if (isNull(category)) {
            throw new BusinessException(ErrorMessages.VETERINARY_REQUIRED);
        }

        return this.persistence.save(category);
    }

    @Override
    public void delete(Integer code) {
        if (isNull(code)) {
            throw new BusinessException(ErrorMessages.VETERINARY_REQUIRED);
        }

        Veterinary categoryFounded = this.get(code);

        if (isNull(categoryFounded)) {
            throw new BusinessException(ErrorMessages.VETERINARY_NOT_FOUND);
        }

        this.persistence.delete(categoryFounded);
    }
}
