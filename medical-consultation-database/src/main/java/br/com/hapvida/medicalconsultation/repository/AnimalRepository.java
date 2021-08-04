package br.com.hapvida.medicalconsultation.repository;

import br.com.hapvida.medicalconsultation.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {

    List<AnimalEntity> findByDeletedAtNotNull();

    List<AnimalEntity> findByDeletedAtNull();

    Optional<AnimalEntity> findByIdAndDeletedAtNull(Integer id);
}
