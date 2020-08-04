package com.globallogic.ejercicio.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.globallogic.ejercicio.dto.User;
import com.globallogic.ejercicio.validator.UserValidator.UserValidatorHelper;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = UserValidatorHelper.class)
public @interface UserValidator {

	String message()

	default "Error";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	public class UserValidatorHelper implements ConstraintValidator<UserValidator, User> {

		@Override
		public boolean isValid(User usr, ConstraintValidatorContext ctx) {
			String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
			boolean isValid;

			isValid = usr.getEmail().matches(regex);
			if (!isValid) {
				ctx.disableDefaultConstraintViolation();
				ctx.buildConstraintViolationWithTemplate("E-mail inválido validator").addPropertyNode("email")
						.addConstraintViolation();
				return false;
			}

			isValid = usr.getPassword().matches("(?=.*[a-z])(?=.*[A-Z])(?=(.*\\\\\\\\d){2})");
			if (!isValid) {
				ctx.disableDefaultConstraintViolation();
				ctx.buildConstraintViolationWithTemplate("Password invalido validator").addPropertyNode("password")
						.addConstraintViolation();
				return false;
			}
			return true;
		}
	}
}
