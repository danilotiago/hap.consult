package br.com.hapvida.medicalconsultation.mapper;

import br.com.hapvida.medicalconsultation.domain.Veterinary;
import br.com.hapvida.medicalconsultation.dto.VeterinaryRequestDTO;
import br.com.hapvida.medicalconsultation.dto.VeterinaryResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VeterinaryMapper {

    VeterinaryMapper INSTANCE = Mappers.getMapper(VeterinaryMapper.class);

    Veterinary from(VeterinaryRequestDTO data);

    VeterinaryResponseDTO from(Veterinary data);

    List<VeterinaryResponseDTO> from(List<Veterinary> data);
}
