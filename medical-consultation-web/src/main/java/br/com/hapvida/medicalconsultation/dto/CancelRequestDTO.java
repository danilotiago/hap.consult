package br.com.hapvida.medicalconsultation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CancelRequestDTO {

    @NotNull(message = "O id da consulta é obrigatório")
    @JsonProperty("consult_id")
    private Integer consultId;
}
