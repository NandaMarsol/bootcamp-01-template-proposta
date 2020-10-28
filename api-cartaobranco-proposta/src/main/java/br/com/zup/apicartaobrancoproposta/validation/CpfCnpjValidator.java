package br.com.zup.apicartaobrancoproposta.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

// classe que representa o nosso validador, implementando a interface ConstraintValidator do Bean Validation
// a interface requer dois parâmetros, o primeiro uma anotação e o segundo o tipo de atributo esperado
public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, CharSequence> {

	// implementando método isValid
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		
		CPFValidator cpfValidator = new CPFValidator();
		CNPJValidator cnpjValidator = new CNPJValidator();
		
		cpfValidator.initialize(null);
		cnpjValidator.initialize(null);
		
		return cpfValidator.isValid(value, context) || cnpjValidator.isValid(value, context);
	}

}
