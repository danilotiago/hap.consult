package br.com.hapvida.medicalconsultation.repository;

import br.com.hapvida.medicalconsultation.entity.VeterinaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeterinaryRepository extends JpaRepository<VeterinaryEntity, Integer> {

    List<VeterinaryEntity> findByDeletedAtNotNull();

    List<VeterinaryEntity> findByDeletedAtNull();

    Optional<VeterinaryEntity> findByIdAndDeletedAtNull(Integer id);
}
