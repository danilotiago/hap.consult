package br.com.hapvida.medicalconsultation.mapper;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.entity.AnimalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnimalEntityMapper {

    AnimalEntityMapper INSTANCE = Mappers.getMapper(AnimalEntityMapper.class);

    Animal from(AnimalEntity data);

    AnimalEntity from(Animal data);

    List<Animal> from(List<AnimalEntity> data);
}
