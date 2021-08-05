package br.com.hapvida.medicalconsultation.controller;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.dto.AllAnimalResponseDTO;
import br.com.hapvida.medicalconsultation.dto.AnimalRequestDTO;
import br.com.hapvida.medicalconsultation.dto.AnimalResponseDTO;
import br.com.hapvida.medicalconsultation.mapper.AnimalMapper;
import br.com.hapvida.medicalconsultation.ports.usecase.AnimalManagerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalController {

    @Autowired
    private AnimalManagerUseCase animalManagerUseCase;

    @GetMapping
    public ResponseEntity<List<AllAnimalResponseDTO>> listAll(
            @RequestParam(name = "only_deleted", required = false) Boolean onlyDeleted,
            @RequestParam(name = "with_deleted", required = false) Boolean withDeleted) {

        List<AllAnimalResponseDTO> response = null;

        if (! isNull(onlyDeleted) && onlyDeleted == true) {
            response = AnimalMapper.INSTANCE.toAll(this.animalManagerUseCase.listOnlyTrashed());
        } else if (! isNull(withDeleted) && withDeleted == true) {
            response = AnimalMapper.INSTANCE.toAll(this.animalManagerUseCase.listWithTrashed());
        } else {
            response = AnimalMapper.INSTANCE.toAll(this.animalManagerUseCase.list());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> find(@PathVariable Integer id) {
        AnimalResponseDTO response = AnimalMapper.INSTANCE.from(this.animalManagerUseCase.get(id));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<AnimalResponseDTO> save(@Valid @RequestBody AnimalRequestDTO data) {
        Animal animal = AnimalMapper.INSTANCE.from(data);
        AnimalResponseDTO response = AnimalMapper.INSTANCE.from(this.animalManagerUseCase.save(animal));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        this.animalManagerUseCase.delete(id);
    }
}
