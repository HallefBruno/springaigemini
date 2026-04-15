package com.ia.aispring.validacao;

import com.ia.aispring.entity.Matricula;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IntervaloDataValidator implements ConstraintValidator<IntervaloDataValido, Matricula> {

    @Override
    public boolean isValid(Matricula matricula, ConstraintValidatorContext context) {
        if (matricula.getDataInicio() == null || matricula.getDataTermino() == null) {
            return true;
        }
        return matricula.getDataInicio().isBefore(matricula.getDataTermino());
    }
}

