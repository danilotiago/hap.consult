package br.com.hapvida.medicalconsultation.mapper;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.domain.Consult;
import br.com.hapvida.medicalconsultation.entity.AnimalEntity;
import br.com.hapvida.medicalconsultation.entity.ConsultEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ConsultEntityMapper {

    ConsultEntityMapper INSTANCE = Mappers.getMapper(ConsultEntityMapper.class);

    ConsultEntity from(Consult consult);

    Consult from(ConsultEntity consult);
}
