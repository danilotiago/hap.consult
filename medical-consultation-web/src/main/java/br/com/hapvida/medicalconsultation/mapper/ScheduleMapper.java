package br.com.hapvida.medicalconsultation.mapper;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.dto.AllAnimalResponseDTO;
import br.com.hapvida.medicalconsultation.dto.AnimalRequestDTO;
import br.com.hapvida.medicalconsultation.dto.AnimalResponseDTO;
import br.com.hapvida.medicalconsultation.dto.SpeciesResponseDTO;
import br.com.hapvida.medicalconsultation.enuns.SpeciesEnum;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);


}
