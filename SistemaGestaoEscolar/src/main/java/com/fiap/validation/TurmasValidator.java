package com.fiap.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TurmasValidator implements ConstraintValidator<Turmas, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("INGLÊS1") || value.equals("INGLÊS2") 
        || value.equals("ESPANHOL1")|| value.equals("ESPANHOL2");
    }
    
}
    

