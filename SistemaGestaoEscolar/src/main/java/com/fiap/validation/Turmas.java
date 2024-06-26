package com.fiap.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TurmasValidator.class)
public @interface Turmas {

    String message() default "{turma.turmas.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
