package br.com.hapvida.medicalconsultation.repository;

import br.com.hapvida.medicalconsultation.entity.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorRepository extends JpaRepository<TutorEntity, Integer> {

    List<TutorEntity> findByDeletedAtNotNull();

    List<TutorEntity> findByDeletedAtNull();

    Optional<TutorEntity> findByIdAndDeletedAtNull(Integer id);
}
