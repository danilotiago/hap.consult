package br.com.hapvida.medicalconsultation.mapper;

import br.com.hapvida.medicalconsultation.domain.Tutor;
import br.com.hapvida.medicalconsultation.dto.TutorRequestDTO;
import br.com.hapvida.medicalconsultation.dto.TutorResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TutorMapper {

    TutorMapper INSTANCE = Mappers.getMapper(TutorMapper.class);

    Tutor from(TutorRequestDTO data);

    TutorResponseDTO from(Tutor data);

    List<TutorResponseDTO> from(List<Tutor> data);
}
