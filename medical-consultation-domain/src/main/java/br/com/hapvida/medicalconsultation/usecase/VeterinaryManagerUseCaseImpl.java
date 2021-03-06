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
    public Veterinary save(Veterinary veterinary) {
        if (isNull(veterinary)) {
            throw new BusinessException(ErrorMessages.VETERINARY_REQUIRED);
        }

        if (isNull(veterinary.getIsActive())) {
            veterinary.setIsActive(Boolean.TRUE);
        }

        return this.persistence.save(veterinary);
    }

    @Override
    public void delete(Integer code) {
        if (isNull(code)) {
            throw new BusinessException(ErrorMessages.VETERINARY_REQUIRED);
        }

        Veterinary veterinaryFounded = this.get(code);

        if (isNull(veterinaryFounded)) {
            throw new BusinessException(ErrorMessages.VETERINARY_NOT_FOUND);
        }

        this.persistence.delete(veterinaryFounded);
    }
}
