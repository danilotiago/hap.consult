package br.com.hapvida.medicalconsultation.ports.persistence;

import br.com.hapvida.medicalconsultation.domain.Animal;

import java.util.List;

public interface AnimalPersistence {

    Animal get(Integer code);

    List<Animal> list();

    List<Animal> listOnlyTrashed();

    List<Animal> listWithTrashed();

    Animal save(Animal animal);

    void delete(Animal animal);

    void active(Animal animal);

    void inactive(Animal animal);
}
