package br.com.hapvida.medicalconsultation.controller;

import br.com.hapvida.medicalconsultation.domain.Veterinary;
import br.com.hapvida.medicalconsultation.dto.VeterinaryRequestDTO;
import br.com.hapvida.medicalconsultation.dto.VeterinaryResponseDTO;
import br.com.hapvida.medicalconsultation.mapper.VeterinaryMapper;
import br.com.hapvida.medicalconsultation.ports.usecase.VeterinaryManagerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/v1/veterinarians")
public class VeterinaryController {

    @Autowired
    private VeterinaryManagerUseCase veterinaryManagerUseCase;

    @GetMapping
    public ResponseEntity<List<VeterinaryResponseDTO>> listAll(
            @RequestParam(name = "only_deleted", required = false) Boolean onlyDeleted,
            @RequestParam(name = "with_deleted", required = false) Boolean withDeleted) {

        List<VeterinaryResponseDTO> response = null;

        if (! isNull(onlyDeleted) && onlyDeleted == true) {
            response = VeterinaryMapper.INSTANCE.from(this.veterinaryManagerUseCase.listOnlyTrashed());
        } else if (! isNull(withDeleted) && withDeleted == true) {
            response = VeterinaryMapper.INSTANCE.from(this.veterinaryManagerUseCase.listWithTrashed());
        } else {
            response = VeterinaryMapper.INSTANCE.from(this.veterinaryManagerUseCase.list());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeterinaryResponseDTO> find(@PathVariable Integer id) {
        VeterinaryResponseDTO response = VeterinaryMapper.INSTANCE.from(this.veterinaryManagerUseCase.get(id));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<VeterinaryResponseDTO> save(@Valid @RequestBody VeterinaryRequestDTO data) {
        Veterinary veterinary = VeterinaryMapper.INSTANCE.from(data);
        VeterinaryResponseDTO response = VeterinaryMapper.INSTANCE.from(this.veterinaryManagerUseCase.save(veterinary));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        this.veterinaryManagerUseCase.delete(id);
    }
}
