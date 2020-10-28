package br.com.zup.apicartaobrancoproposta.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

import br.com.zup.apicartaobrancoproposta.validation.CpfCnpj;

@Entity // entidade no banco de dados
public class Proposta {

	@Id // identificador da entidade
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String endereco;
	@NotNull
	@Positive
	private BigDecimal salario;
	@NotBlank @CpfCnpj
	private String documento;
	
	

	// construtor com validações
	public Proposta(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String endereco,
			@Positive BigDecimal salario, String documento) {
		super();
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.documento = documento;
	}



	public Long getId() {
		Assert.notNull(id, "O objeto precisa estar salvo para chamar o getId");
		return id;
	}
	
	
}
