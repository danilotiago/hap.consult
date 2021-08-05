package br.com.hapvida.medicalconsultation.services;

import br.com.hapvida.medicalconsultation.domain.Animal;
import br.com.hapvida.medicalconsultation.domain.Consult;
import br.com.hapvida.medicalconsultation.domain.Veterinary;
import br.com.hapvida.medicalconsultation.enuns.ConsultEnum;
import br.com.hapvida.medicalconsultation.enuns.SpeciesEnum;
import br.com.hapvida.medicalconsultation.exceptions.BusinessException;
import br.com.hapvida.medicalconsultation.messages.ErrorMessages;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Regras de crédito de agendamento de consulta")
public class ScheduledServiceTest {

    ScheduledService scheduledService = new ScheduledService();

    Animal animal;
    Veterinary veterinary;
    LocalDateTime date;

    @BeforeEach
    public void prepareBefore() {
        this.animal = new Animal();
        this.animal.setIsActive(Boolean.TRUE);
        this.animal.setName("Animal name");

        this.veterinary = new Veterinary();
        this.veterinary.setIsActive(Boolean.TRUE);
        this.veterinary.setName("Veterinary name");

        this.date = LocalDateTime.now();
    }

    @Test
    @DisplayName("Verifica se uma exceção é lançada caso um animal nulo seja passado")
    void shouldBeThrowsBusinessException_whenHasNullableAnimal() {

        BusinessException businessException = assertThrows(
                BusinessException.class,
                () -> this.scheduledService.scheduled(null, veterinary, date));

        assertEquals(businessException.getMessage(), ErrorMessages.ANIMAL_REQUIRED);
    }

    @Test
    @DisplayName("Verifica se uma exceção é lançada caso um veterinário nulo seja passado")
    void shouldBeThrowsBusinessException_whenHasNullableVeterinary() {

        BusinessException businessException = assertThrows(
                BusinessException.class,
                () -> this.scheduledService.scheduled(animal, null, date));

        assertEquals(businessException.getMessage(), ErrorMessages.VETERINARY_REQUIRED);
    }

    @Test
    @DisplayName("Verifica se uma exceção é lançada caso uma data de agendamento nula seja passada")
    void shouldBeThrowsBusinessException_whenHasNullableScheduledDate() {

        BusinessException businessException = assertThrows(
                BusinessException.class,
                () -> this.scheduledService.scheduled(animal, veterinary, null));

        assertEquals(businessException.getMessage(), ErrorMessages.DATE_REQUIRED);
    }

    @Test
    @DisplayName("Verifica se um agendamento é feito com sucesso")
    void shouldBeScheduledConsult() {

        Consult scheduled = this.scheduledService.scheduled(animal, veterinary, date);

        assertTrue(scheduled.getStatus().equals(ConsultEnum.SCHEDULED));
    }
}
