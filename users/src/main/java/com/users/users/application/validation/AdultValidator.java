package com.users.users.application.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AdultValidator implements ConstraintValidator<Adult, LocalDate> {

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext context) {
        if (birthDate == null) {
            return false;
        }

        LocalDate today = LocalDate.now();
        LocalDate adultAge = today.minusYears(18);

        return birthDate.isBefore(adultAge) || birthDate.equals(adultAge);
    }
}
