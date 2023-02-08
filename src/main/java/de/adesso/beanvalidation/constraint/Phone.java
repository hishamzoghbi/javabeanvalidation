package de.adesso.beanvalidation.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
@Documented
public @interface Phone {
    
    String message() default "Please check ur phone number ${validatedValue}";
	
	
	//Required by Validation runtime
	Class<?>[] groups() default{};
	
	
	//Required by Validation runtime
	Class<? extends Phone> [] payload() default{};

}
