package br.com.hapvida.medicalconsultation.mapper;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.entity.AnimalEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnimalEntityMapper {

    AnimalEntityMapper INSTANCE = Mappers.getMapper(AnimalEntityMapper.class);

    Animal from(AnimalEntity data, @Context CycleAvoidingMappingContext context);

    AnimalEntity from(Animal data, @Context CycleAvoidingMappingContext context);

    List<Animal> from(List<AnimalEntity> data, @Context CycleAvoidingMappingContext context);
}
