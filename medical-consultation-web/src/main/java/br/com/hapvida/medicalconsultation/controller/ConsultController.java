package br.com.hapvida.medicalconsultation.controller;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.domain.Consult;
import br.com.hapvida.medicalconsultation.dto.*;
import br.com.hapvida.medicalconsultation.mapper.AnimalMapper;
import br.com.hapvida.medicalconsultation.mapper.ConsultMapper;
import br.com.hapvida.medicalconsultation.ports.usecase.AnimalManagerUseCase;
import br.com.hapvida.medicalconsultation.ports.usecase.ScheduleConsultUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/v1/consults")
public class ConsultController {

    @Autowired
    private ScheduleConsultUseCase scheduleConsultUseCase;

    @PostMapping("/schedule")
    public ResponseEntity<ConsultResponseDTO> save(@Valid @RequestBody ScheduleRequestDTO data) {
        Consult consult = this.scheduleConsultUseCase.schedule(data.getAnimalId(), data.getVeterinaryId());

        ConsultResponseDTO response = ConsultMapper.INSTANCE.from(consult);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

//    @PostMapping("/cancel")
//    public ResponseEntity<AnimalResponseDTO> save(@Valid @RequestBody AnimalRequestDTO data) {
//        Animal animal = AnimalMapper.INSTANCE.from(data);
//        AnimalResponseDTO response = AnimalMapper.INSTANCE.from(this.animalManagerUseCase.save(animal));
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }
}
