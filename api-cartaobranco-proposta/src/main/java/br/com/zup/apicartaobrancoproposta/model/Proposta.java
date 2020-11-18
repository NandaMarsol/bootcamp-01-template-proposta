package br.com.zup.apicartaobrancoproposta.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.Assert;

import br.com.zup.apicartaobrancoproposta.validation.CpfCnpj;

@Entity // entidade no banco de dados
@NamedQuery(name = "findPropostaByDocumento", query = "select p from Proposta p where p.documento = :documento")
public class Proposta {

	@Id // identificador da entidade
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
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
	
	@Enumerated(EnumType.STRING)
	private StatusDaProposta statusDaProposta;
	
	@Deprecated
	public Proposta(){	
	}
	
	// construtor com validações
	public Proposta(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String endereco,
			@NotNull @Positive BigDecimal salario, @NotBlank String documento) {
		super();
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.documento = documento;
		
	}

	public String getId() {
		Assert.notNull(id, "O objeto precisa estar salvo para chamar o getId");
		return id;
	}


	public String getDocumento() {
		return documento;
	}


	public String getNome() {
		return nome;
	}


	public void atualizaStatusProposta(StatusDaProposta statusDaProposta) {
		Assert.notNull(statusDaProposta, "O status da proposta não pode ser nulo para a atualização");
		this.statusDaProposta = statusDaProposta;
	}

	@Override
	public String toString() {
		return "Proposta [id=" + id + ", email=" + email + ", nome=" + nome + ", endereco=" + endereco + ", salario="
				+ salario + ", documento=" + documento + ", statusDaProposta=" + statusDaProposta + "]";
	}
	
}
