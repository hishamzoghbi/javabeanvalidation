package de.adesso.beanvalidation.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class PhoneValidator implements ConstraintValidator<Phone, String>{
    
	@Override
	public void initialize(Phone constraintAnnotation) {
		
	}

    @Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) {
			return false;
		}
		return value.startsWith("+49");
	}

}