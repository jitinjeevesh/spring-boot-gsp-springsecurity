package com.utils.validator;


import com.dto.RegistrationDto;
import com.utils.annotation.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        RegistrationDto registrationDto = (RegistrationDto) obj;
        return registrationDto.getPassword().equals(registrationDto.getConfirmPassword());
    }
}