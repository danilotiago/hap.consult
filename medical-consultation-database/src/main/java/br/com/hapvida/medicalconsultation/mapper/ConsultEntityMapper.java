package br.com.hapvida.medicalconsultation.mapper;

import br.com.hapvida.medicalconsultation.domain.Consult;
import br.com.hapvida.medicalconsultation.entity.ConsultEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConsultEntityMapper {

    ConsultEntityMapper INSTANCE = Mappers.getMapper(ConsultEntityMapper.class);

    ConsultEntity from(Consult consult, @Context CycleAvoidingMappingContext context);

    Consult from(ConsultEntity consult, @Context CycleAvoidingMappingContext context);
}
