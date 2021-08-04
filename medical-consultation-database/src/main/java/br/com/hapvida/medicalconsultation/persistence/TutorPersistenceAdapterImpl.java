package br.com.hapvida.medicalconsultation.persistence;

import br.com.hapvida.medicalconsultation.domain.Tutor;
import br.com.hapvida.medicalconsultation.entity.TutorEntity;
import br.com.hapvida.medicalconsultation.mapper.TutorEntityMapper;
import br.com.hapvida.medicalconsultation.ports.persistence.TutorPersistence;
import br.com.hapvida.medicalconsultation.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class TutorPersistenceAdapterImpl implements TutorPersistence {

    @Autowired
    private TutorRepository repository;

    @Override
    public Tutor get(Integer id) {
        Optional<TutorEntity> result = this.repository.findByIdAndDeletedAtNull(id);
        if (result.isPresent()) {
            return TutorEntityMapper.INSTANCE.from(result.get());
        }

        throw new EntityNotFoundException("O tutor de código " + id + " não foi encontrado");
    }

    @Override
    public List<Tutor> list() {
        List<TutorEntity> tutors = this.repository.findByDeletedAtNull();
        return TutorEntityMapper.INSTANCE.from(tutors);
    }

    @Override
    public List<Tutor> listOnlyTrashed() {
        List<TutorEntity> tutors =  this.repository.findByDeletedAtNotNull();

        return TutorEntityMapper.INSTANCE.from(tutors);
    }

    @Override
    public List<Tutor> listWithTrashed() {
        List<Tutor> tutors = this.list();
        tutors.addAll(this.listOnlyTrashed());

        return tutors;
    }

    @Override
    public Tutor save(Tutor tutor) {
        TutorEntity tutorEntity = TutorEntityMapper.INSTANCE.from(tutor);
        tutorEntity = this.repository.save(tutorEntity);
        return TutorEntityMapper.INSTANCE.from(tutorEntity);
    }

    @Override
    public void delete(Tutor tutor) {
        this.repository.deleteById(tutor.getId());
    }

    @Override
    public void active(Tutor tutor) {
        this.save(tutor);
    }

    @Override
    public void inactive(Tutor tutor) {
        this.save(tutor);
    }
}
