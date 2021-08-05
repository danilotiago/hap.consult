package br.com.hapvida.medicalconsultation.mapper;

import br.com.hapvida.medicalconsultation.domain.Tutor;
import br.com.hapvida.medicalconsultation.entity.TutorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TutorEntityMapper {

    TutorEntityMapper INSTANCE = Mappers.getMapper(TutorEntityMapper.class);

    @Mapping(target = "animal", ignore = true)
    Tutor from(TutorEntity data);

    TutorEntity from(Tutor data);

    @Mapping(target = "animal", ignore = true)
    List<Tutor> from(List<TutorEntity> data);
}
