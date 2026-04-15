package com.ia.aispring.validacao;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class IdadeMinimaLocalDateValidator implements ConstraintValidator<IdadeMinimaLocalDate, LocalDate> {
    private int idadeMinima;

    @Override
    public void initialize(IdadeMinimaLocalDate constraintAnnotation) {
        this.idadeMinima = constraintAnnotation.valor();
    }

    @Override
    public boolean isValid(LocalDate dataNascimento, ConstraintValidatorContext context) {
        if (dataNascimento == null) return true;
        return Period.between(dataNascimento, LocalDate.now()).getYears() >= idadeMinima;
    }
}