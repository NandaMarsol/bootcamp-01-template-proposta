package br.com.zup.apicartaobrancoproposta.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import br.com.zup.apicartaobrancoproposta.request.NovaPropostaRequest;

// classe para validar se o documento CPF/CNPJ for igual, pois não pode haver mais de uma proposta por solicitante

@Component
public class DocumentoIgualValidator {
	
	@PersistenceContext
	private EntityManager manager; // serve para gravar no banco de dados
	
	// método para validar se o documento é igual
	public boolean docValido(NovaPropostaRequest request) { // usa os dados da NovaProposta como parâmetros
		
		// pesquisando no banco de dados as infos do documento
		// :documento para indicar o parâmetro
		return manager.createQuery("select p.documento from Proposta p where p.documento = :documento") 
				.setParameter("documento", request.getDocumento()) // passando documento como parâmetro
				.getResultList().isEmpty(); // devolve uma lista vazia
		
	}

}
