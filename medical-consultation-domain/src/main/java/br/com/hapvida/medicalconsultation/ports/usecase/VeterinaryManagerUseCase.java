package br.com.hapvida.medicalconsultation.ports.usecase;

import br.com.hapvida.medicalconsultation.domain.Veterinary;

import java.util.List;

public interface VeterinaryManagerUseCase {

    Veterinary get(Integer code);

    List<Veterinary> list();

    List<Veterinary> listWithTrashed();

    List<Veterinary> listOnlyTrashed();

    Veterinary save(Veterinary veterinary);

    void delete(Integer code);
}
