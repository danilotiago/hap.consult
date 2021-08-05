package br.com.hapvida.medicalconsultation.mapper;

import br.com.hapvida.medicalconsultation.domain.Consult;
import br.com.hapvida.medicalconsultation.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConsultMapper {

    ConsultMapper INSTANCE = Mappers.getMapper(ConsultMapper.class);

    ConsultResponseDTO from(Consult data);
}
