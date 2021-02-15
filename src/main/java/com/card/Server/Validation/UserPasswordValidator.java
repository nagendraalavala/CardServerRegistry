package com.card.Server.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserPasswordValidator implements ConstraintValidator<UserPasswordConstraint, String> {

    @Override
    public void initialize(UserPasswordConstraint constraint) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return password != null && password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
                && (password.length() > 8);
    }

}
