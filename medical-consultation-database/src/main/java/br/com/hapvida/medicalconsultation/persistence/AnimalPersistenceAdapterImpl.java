package br.com.hapvida.medicalconsultation.persistence;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.entity.AnimalEntity;
import br.com.hapvida.medicalconsultation.mapper.AnimalEntityMapper;
import br.com.hapvida.medicalconsultation.mapper.TutorEntityMapper;
import br.com.hapvida.medicalconsultation.ports.persistence.AnimalPersistence;
import br.com.hapvida.medicalconsultation.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class AnimalPersistenceAdapterImpl implements AnimalPersistence {

    @Autowired
    private AnimalRepository repository;

    @Override
    public Animal get(Integer id) {
        Optional<AnimalEntity> result = this.repository.findByIdAndDeletedAtNull(id);
        if (result.isPresent()) {
            Animal animal = AnimalEntityMapper.INSTANCE.from(result.get());
            animal.setTutors(TutorEntityMapper.INSTANCE.from(result.get().getTutors()));
            return animal;
        }

        throw new EntityNotFoundException("O animal de código " + id + " não foi encontrado");
    }

    @Override
    public List<Animal> list() {
        List<AnimalEntity> animals = this.repository.findByDeletedAtNull();
        return AnimalEntityMapper.INSTANCE.from(animals);
    }

    @Override
    public List<Animal> listOnlyTrashed() {
        List<AnimalEntity> animals =  this.repository.findByDeletedAtNotNull();

        return AnimalEntityMapper.INSTANCE.from(animals);
    }

    @Override
    public List<Animal> listWithTrashed() {
        List<Animal> animals = this.list();
        animals.addAll(this.listOnlyTrashed());

        return animals;
    }

    @Override
    public Animal save(Animal animal) {
        AnimalEntity animalEntity = AnimalEntityMapper.INSTANCE.from(animal);
        animalEntity = this.repository.save(animalEntity);
        return AnimalEntityMapper.INSTANCE.from(animalEntity);
    }

    @Override
    public void delete(Animal animal) {
        this.repository.deleteById(animal.getId());
    }

    @Override
    public void active(Animal animal) {
        this.save(animal);
    }

    @Override
    public void inactive(Animal animal) {
        this.save(animal);
    }
}
