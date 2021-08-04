package br.com.hapvida.medicalconsultation.ports.persistence;

import br.com.hapvida.medicalconsultation.domain.Veterinary;

import java.util.List;

public interface VeterinaryPersistence {

    Veterinary get(Integer code);

    List<Veterinary> list();

    List<Veterinary> listOnlyTrashed();

    List<Veterinary> listWithTrashed();

    Veterinary save(Veterinary Veterinary);

    void delete(Veterinary Veterinary);

    void active(Veterinary Veterinary);

    void inactive(Veterinary Veterinary);
}
