package br.com.hapvida.medicalconsultation.ports.persistence;

import br.com.hapvida.medicalconsultation.domain.Tutor;

import java.util.List;

public interface TutorPersistence {

    Tutor get(Integer code);

    List<Tutor> list();

    List<Tutor> listOnlyTrashed();

    List<Tutor> listWithTrashed();

    Tutor save(Tutor Tutor);

    void delete(Tutor Tutor);

    void active(Tutor Tutor);

    void inactive(Tutor Tutor);
}
