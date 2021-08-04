package br.com.hapvida.medicalconsultation.mapper;

import br.com.hapvida.medicalconsultation.domain.Veterinary;
import br.com.hapvida.medicalconsultation.entity.VeterinaryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VeterinaryEntityMapper {

    VeterinaryEntityMapper INSTANCE = Mappers.getMapper(VeterinaryEntityMapper.class);

    Veterinary from(VeterinaryEntity data);

    VeterinaryEntity from(Veterinary data);

    List<Veterinary> from(List<VeterinaryEntity> data);
}
