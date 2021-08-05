package br.com.hapvida.medicalconsultation.controller;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.domain.Consult;
import br.com.hapvida.medicalconsultation.dto.*;
import br.com.hapvida.medicalconsultation.mapper.AnimalMapper;
import br.com.hapvida.medicalconsultation.mapper.ConsultMapper;
import br.com.hapvida.medicalconsultation.ports.usecase.AnimalManagerUseCase;
import br.com.hapvida.medicalconsultation.ports.usecase.CancelConsultUseCase;
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

    @Autowired
    private CancelConsultUseCase cancelConsultUseCase;

    @PostMapping("/schedule")
    public ResponseEntity<ConsultResponseDTO> schedule(@Valid @RequestBody ScheduleRequestDTO data) {
        Consult consult = this.scheduleConsultUseCase.schedule(data.getAnimalId(), data.getVeterinaryId());

        ConsultResponseDTO response = ConsultMapper.INSTANCE.from(consult);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @PostMapping("/cancel")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void cancel(@Valid @RequestBody CancelRequestDTO data) {
        this.cancelConsultUseCase.cancel(data.getConsultId());
    }
}
