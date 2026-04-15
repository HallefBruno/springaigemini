package com.ia.aispring.validacao;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IntervaloDataValidator.class)
public @interface IntervaloDataValido {
    String message() default "A data de início deve ser anterior à data de término";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
