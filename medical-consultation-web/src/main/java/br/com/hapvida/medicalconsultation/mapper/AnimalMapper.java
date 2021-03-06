package br.com.hapvida.medicalconsultation.mapper;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.dto.AllAnimalResponseDTO;
import br.com.hapvida.medicalconsultation.dto.AnimalRequestDTO;
import br.com.hapvida.medicalconsultation.dto.AnimalResponseDTO;
import br.com.hapvida.medicalconsultation.dto.SpeciesResponseDTO;
import br.com.hapvida.medicalconsultation.enuns.SpeciesEnum;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnimalMapper {

    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

    Animal from(AnimalRequestDTO data);

    AnimalResponseDTO from(Animal data);

    List<AnimalResponseDTO> from(List<Animal> data);

    List<AllAnimalResponseDTO> toAll(List<Animal> data);

    default SpeciesEnum map(Integer value) {
        return SpeciesEnum.get(value);
    }

    default SpeciesResponseDTO map(SpeciesEnum value) {
        return new SpeciesResponseDTO(value.getCode(), value.name());
    }
}
