package br.com.hapvida.medicalconsultation.ports.usecase;

import br.com.hapvida.medicalconsultation.domain.Animal;

import java.util.List;

public interface AnimalManagerUseCase {

    Animal get(Integer code);

    List<Animal> list();

    List<Animal> listWithTrashed();

    List<Animal> listOnlyTrashed();

    Animal save(Animal animal);

    void delete(Integer code);
}
