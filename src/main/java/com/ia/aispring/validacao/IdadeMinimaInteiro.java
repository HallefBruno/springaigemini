package com.ia.aispring.validacao;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdadeMinimaInteiroValidator.class)
public @interface IdadeMinimaInteiro {
	
	String message() default "Deve ter pelo menos 18 anos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
	
}
