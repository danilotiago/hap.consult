package br.com.hapvida.medicalconsultation.mapper;

import br.com.hapvida.medicalconsultation.domain.Tutor;
import br.com.hapvida.medicalconsultation.entity.TutorEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TutorEntityMapper {

    TutorEntityMapper INSTANCE = Mappers.getMapper(TutorEntityMapper.class);

    Tutor from(TutorEntity data, @Context CycleAvoidingMappingContext context);

    TutorEntity from(Tutor data, @Context CycleAvoidingMappingContext context);

    List<Tutor> from(List<TutorEntity> data, @Context CycleAvoidingMappingContext context);
}
