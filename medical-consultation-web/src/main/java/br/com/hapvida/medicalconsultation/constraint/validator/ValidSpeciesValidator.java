package br.com.hapvida.medicalconsultation.constraint.validator;

import br.com.hapvida.medicalconsultation.constraint.annotation.ValidSpecies;
import br.com.hapvida.medicalconsultation.enuns.SpeciesEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class ValidSpeciesValidator implements ConstraintValidator<ValidSpecies, Integer> {

    @Override
    public void initialize(ValidSpecies text) {
    }

    @Override
    public boolean isValid(Integer specie, ConstraintValidatorContext cxt) {
        return ! isNull(SpeciesEnum.get(specie));
    }
}
