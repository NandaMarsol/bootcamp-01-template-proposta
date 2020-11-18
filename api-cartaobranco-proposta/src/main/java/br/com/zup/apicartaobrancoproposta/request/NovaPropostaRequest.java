package br.com.zup.apicartaobrancoproposta.request;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zup.apicartaobrancoproposta.model.Proposta;
import br.com.zup.apicartaobrancoproposta.validation.CpfCnpj;

// classe específica criada para recebimento de parâmetros
// representa os dados de entrada de um endpoint
public class NovaPropostaRequest {
	
	// validando os atributos 
	@NotBlank @Email private String email;
	@NotBlank private String nome;
	@NotBlank private String endereco;
	@NotNull @Positive private BigDecimal salario;
	@NotBlank @CpfCnpj private String documento;
	
	@Deprecated
	public NovaPropostaRequest() {
		
	}
	
	// construtor também com validações 
	public NovaPropostaRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank  String endereco, @Positive BigDecimal salario, @NotBlank String documento) {
		super();
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.documento = documento;
	}

	// método toModel para criar uma nova "Proposta" 
	public Proposta toModel() {
		return new Proposta(email, nome, endereco, salario, documento);
	}

	// getters
	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public String getDocumento() {
		return documento;
	}
	
}



/*
 * O objetivo dessa classe é proteger a classe de domínio "Proposta"
 * separando as "bordas" externas do sistema do seu núcleo. 
 * As anotações nos atributos são validações (Bean Validation) 
 * feitas para não aceitarmos parâmetros com valores inválidos.
 */