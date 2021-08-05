package br.com.hapvida.medicalconsultation.persistence;

import br.com.hapvida.medicalconsultation.domain.Consult;
import br.com.hapvida.medicalconsultation.domain.Veterinary;
import br.com.hapvida.medicalconsultation.entity.AnimalEntity;
import br.com.hapvida.medicalconsultation.entity.ConsultEntity;
import br.com.hapvida.medicalconsultation.entity.VeterinaryEntity;
import br.com.hapvida.medicalconsultation.exceptions.BusinessException;
import br.com.hapvida.medicalconsultation.mapper.ConsultEntityMapper;
import br.com.hapvida.medicalconsultation.messages.ErrorMessages;
import br.com.hapvida.medicalconsultation.ports.persistence.ConsultPersistence;
import br.com.hapvida.medicalconsultation.repository.AnimalRepository;
import br.com.hapvida.medicalconsultation.repository.ConsultRepository;
import br.com.hapvida.medicalconsultation.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Optional;

@Component
public class ConsultPersistenceAdapterImpl implements ConsultPersistence {

    @Autowired
    private ConsultRepository consultRepository;

    @Autowired
    private VeterinaryRepository veterinaryRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public Consult get(Integer consultId) {
        Optional<ConsultEntity> result = this.consultRepository.findById(consultId);

        if (result.isPresent()) {
            return ConsultEntityMapper.INSTANCE.from(result.get());
        }

        throw new EntityNotFoundException("A consulta de código " + consultId + " não foi encontrada");
    }

    @Override
    public Boolean existsBy(Integer animalId, Integer veterinaryId, LocalDate date) {

        AnimalEntity animal = this.animalRepository.getById(animalId);

        VeterinaryEntity veterinary = this.veterinaryRepository.getById(veterinaryId);

        return this.consultRepository.existsConsultEntityByVeterinaryAndAnimalAndDate(veterinary, animal, date);
    }

    @Override
    public Consult schedule(Consult consult) {
        ConsultEntity consultEntity = ConsultEntityMapper.INSTANCE.from(consult);
        consultEntity = this.consultRepository.save(consultEntity);
        return ConsultEntityMapper.INSTANCE.from(consultEntity);
    }

    @Override
    public Consult cancel(Consult consult) {
        ConsultEntity consultEntity = ConsultEntityMapper.INSTANCE.from(consult);
        consultEntity = this.consultRepository.save(consultEntity);
        return ConsultEntityMapper.INSTANCE.from(consultEntity);
    }
}
