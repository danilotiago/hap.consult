package br.com.hapvida.medicalconsultation.constraint.annotation;

import br.com.hapvida.medicalconsultation.constraint.validator.ValidSpeciesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidSpeciesValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSpecies {

    String message() default "Espécie inválida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
