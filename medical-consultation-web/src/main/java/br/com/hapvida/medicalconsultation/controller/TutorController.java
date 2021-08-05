package br.com.hapvida.medicalconsultation.controller;

import br.com.hapvida.medicalconsultation.domain.Tutor;
import br.com.hapvida.medicalconsultation.dto.TutorRequestDTO;
import br.com.hapvida.medicalconsultation.dto.TutorResponseDTO;
import br.com.hapvida.medicalconsultation.mapper.TutorMapper;
import br.com.hapvida.medicalconsultation.ports.usecase.AnimalManagerUseCase;
import br.com.hapvida.medicalconsultation.ports.usecase.TutorManagerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/v1/tutors")
public class TutorController {

    @Autowired
    private TutorManagerUseCase tutorManagerUseCase;

    @Autowired
    private AnimalManagerUseCase animalManagerUseCase;

    @GetMapping
    public ResponseEntity<List<TutorResponseDTO>> listAll(
            @RequestParam(name = "only_deleted", required = false) Boolean onlyDeleted,
            @RequestParam(name = "with_deleted", required = false) Boolean withDeleted) {

        List<TutorResponseDTO> response = null;

        if (! isNull(onlyDeleted) && onlyDeleted == true) {
            response = TutorMapper.INSTANCE.from(this.tutorManagerUseCase.listOnlyTrashed());
        } else if (! isNull(withDeleted) && withDeleted == true) {
            response = TutorMapper.INSTANCE.from(this.tutorManagerUseCase.listWithTrashed());
        } else {
            response = TutorMapper.INSTANCE.from(this.tutorManagerUseCase.list());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorResponseDTO> find(@PathVariable Integer id) {
        TutorResponseDTO response = TutorMapper.INSTANCE.from(this.tutorManagerUseCase.get(id));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TutorResponseDTO> save(@Valid @RequestBody TutorRequestDTO data) {
        Tutor tutor = TutorMapper.INSTANCE.from(data);
        tutor.setAnimal(this.animalManagerUseCase.get(data.getAnimalId()));
        TutorResponseDTO response = TutorMapper.INSTANCE.from(this.tutorManagerUseCase.save(tutor));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        this.tutorManagerUseCase.delete(id);
    }
}
