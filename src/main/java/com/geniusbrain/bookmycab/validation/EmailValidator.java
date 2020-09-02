package com.geniusbrain.bookmycab.validation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private String validationString;
    @Override
    public void initialize(ValidEmail emailValidator) {
        this.validationString = emailValidator.value();
    }

    @Override
    public boolean isValid(String enteredString, ConstraintValidatorContext constraintValidatorContext) {
        return enteredString.endsWith(validationString);
    }
}
