package br.com.hapvida.medicalconsultation.usecase;

import br.com.hapvida.medicalconsultation.domain.Tutor;
import br.com.hapvida.medicalconsultation.exceptions.BusinessException;
import br.com.hapvida.medicalconsultation.messages.ErrorMessages;
import br.com.hapvida.medicalconsultation.ports.persistence.TutorPersistence;
import br.com.hapvida.medicalconsultation.ports.usecase.TutorManagerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Objects.isNull;

@Component
public class TutorManagerUseCaseImpl implements TutorManagerUseCase {

    @Autowired
    private TutorPersistence persistence;

    @Override
    public Tutor get(Integer code) {
        if (isNull(code)) {
            throw new BusinessException(ErrorMessages.TUTOR_CODE_REQUIRED);
        }
        return this.persistence.get(code);
    }

    @Override
    public List<Tutor> list() {
        return this.persistence.list();
    }

    @Override
    public List<Tutor> listWithTrashed() {
        return this.persistence.listWithTrashed();
    }

    @Override
    public List<Tutor> listOnlyTrashed() {
        return this.persistence.listOnlyTrashed();
    }

    @Override
    public Tutor save(Tutor tutor) {
        if (isNull(tutor)) {
            throw new BusinessException(ErrorMessages.TUTOR_REQUIRED);
        }

        if (isNull(tutor.getIsActive())) {
            tutor.setIsActive(Boolean.TRUE);
        }

        return this.persistence.save(tutor);
    }

    @Override
    public void delete(Integer code) {
        if (isNull(code)) {
            throw new BusinessException(ErrorMessages.TUTOR_REQUIRED);
        }

        Tutor tutorFounded = this.get(code);

        if (isNull(tutorFounded)) {
            throw new BusinessException(ErrorMessages.TUTOR_NOT_FOUND);
        }

        this.persistence.delete(tutorFounded);
    }
}
