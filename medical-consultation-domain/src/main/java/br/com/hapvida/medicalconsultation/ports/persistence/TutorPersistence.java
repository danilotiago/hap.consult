package br.com.hapvida.medicalconsultation.ports.persistence;

import br.com.hapvida.medicalconsultation.domain.Tutor;

import java.util.List;

public interface TutorPersistence {

    Tutor get(Integer code);

    List<Tutor> list();

    List<Tutor> listOnlyTrashed();

    List<Tutor> listWithTrashed();

    Tutor save(Tutor tutor);

    void delete(Tutor tutor);

    void active(Tutor tutor);

    void inactive(Tutor tutor);
}
