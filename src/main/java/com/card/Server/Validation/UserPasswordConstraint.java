package com.card.Server.Validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserPasswordValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserPasswordConstraint {
    String message() default "Choose the correct password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
