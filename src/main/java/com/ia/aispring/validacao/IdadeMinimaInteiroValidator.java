package com.ia.aispring.validacao;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdadeMinimaInteiroValidator implements ConstraintValidator<IdadeMinimaInteiro, Integer> {

	@Override
	public boolean isValid(Integer idade, ConstraintValidatorContext cvc) {
		if (idade == null) return true;
		return idade >= 18;
	}
	
}
