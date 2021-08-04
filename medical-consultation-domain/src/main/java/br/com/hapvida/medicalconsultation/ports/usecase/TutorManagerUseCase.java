package br.com.hapvida.medicalconsultation.ports.usecase;

import br.com.hapvida.medicalconsultation.domain.Tutor;

import java.util.List;

public interface TutorManagerUseCase {

    Tutor get(Integer code);

    List<Tutor> list();

    List<Tutor> listWithTrashed();

    List<Tutor> listOnlyTrashed();

    Tutor save(Tutor category);

    void delete(Integer code);
}
