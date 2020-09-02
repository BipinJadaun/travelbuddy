package com.geniusbrain.bookmycab.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {

    public String value() default ".com";

    public String message() default "email id must ends with '.com'";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
