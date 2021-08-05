package br.com.hapvida.medicalconsultation.services;

import br.com.hapvida.medicalconsultation.domain.Consult;
import br.com.hapvida.medicalconsultation.enuns.ConsultEnum;
import br.com.hapvida.medicalconsultation.exceptions.BusinessException;
import br.com.hapvida.medicalconsultation.messages.ErrorMessages;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static java.util.Objects.isNull;

@Component
public class CancelService {

    public void cancel(Consult consult) {
        if (isNull(consult)) {
            throw new BusinessException(ErrorMessages.CONSULT_REQUIRED);
        }

        if (consult.getDate().getDayOfMonth() == LocalDateTime.now().getDayOfMonth()) {
            throw new BusinessException(ErrorMessages.CANCEL_TODAY_CONSULT);
        }

        consult.setStatus(ConsultEnum.CANCELED);
    }
}
