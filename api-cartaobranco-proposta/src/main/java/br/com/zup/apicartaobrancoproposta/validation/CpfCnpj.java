package br.com.zup.apicartaobrancoproposta.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//criando nossa anotação de validação CPF ou CNPJ
@Documented
@Constraint(validatedBy = CpfCnpjValidator.class) // anotação é uma Constraint
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfCnpj {
	
	String message() default "O documento CPF/CNPJ é inválido!";
	
	Class<?>[] groups() default {
	};
	
	Class<? extends Payload>[] payload() default {
	};

}
