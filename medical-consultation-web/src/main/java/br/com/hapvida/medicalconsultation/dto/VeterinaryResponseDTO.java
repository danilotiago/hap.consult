package br.com.hapvida.medicalconsultation.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VeterinaryResponseDTO {

    private Integer id;

    private String name;

    private String phone;

    private String email;

    private Boolean isActive;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
