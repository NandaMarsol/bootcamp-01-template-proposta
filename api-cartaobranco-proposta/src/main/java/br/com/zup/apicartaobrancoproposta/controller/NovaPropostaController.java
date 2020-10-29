package br.com.zup.apicartaobrancoproposta.controller;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.apicartaobrancoproposta.model.Proposta;
import br.com.zup.apicartaobrancoproposta.request.NovaPropostaRequest;
import br.com.zup.apicartaobrancoproposta.validation.DocumentoIgualValidator;

@RestController
public class NovaPropostaController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	DocumentoIgualValidator documentoIgualValidator;
	
	// endpoint de criação de uma nova proposta - método POST
	@PostMapping(value = "/api/propostas") 
	@Transactional
	// realizando a conversão de classes direto no ponto de recebimento do parâmetro que representa os dados da requisição
	public ResponseEntity<?> criaProposta(@Valid @RequestBody NovaPropostaRequest request, UriComponentsBuilder builder) { // protegendo a borda na entrada
		
		if(!documentoIgualValidator.docValido(request)) { // se for igual
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Este documento já está cadastrado!"); // retornando status code 422
		}
		
		
		Proposta novaProposta = request.toModel(); // toModel comportamento para criar uma nova Proposta
		manager.persist(novaProposta);
		
		URI enderecoConsulta = builder.path("/api/propostas/{id}").build(novaProposta.getId());
		return ResponseEntity.created(enderecoConsulta).build();
		
	}

}

/*
 * ResponseEntity: essa classe serve para passar todas as informações da requisição HTTP
 * ResponseEntity.created nos retorna o status 201 
 * 
 * UriComponentsBuilder: classe utilitária que ajuda a criar URIS
 * essa classe nos ajuda a lidar com problemas comuns de encodings presentes nas URIS
 */