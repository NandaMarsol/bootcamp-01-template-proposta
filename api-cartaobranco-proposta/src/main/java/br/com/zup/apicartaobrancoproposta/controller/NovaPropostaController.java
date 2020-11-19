package br.com.zup.apicartaobrancoproposta.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.apicartaobrancoproposta.exception.StandardError;
import br.com.zup.apicartaobrancoproposta.model.Proposta;
import br.com.zup.apicartaobrancoproposta.repository.PropostaRepository;
import br.com.zup.apicartaobrancoproposta.request.NovaPropostaRequest;
import br.com.zup.apicartaobrancoproposta.service.AnaliseClienteService;

@RestController
public class NovaPropostaController {

	private PropostaRepository propostaRepository;
	
	private AnaliseClienteService analiseClienteService;

	private Logger logger;
	

	public NovaPropostaController(PropostaRepository propostaRepository, AnaliseClienteService analiseClienteService) {
		super();
		this.propostaRepository = propostaRepository;
		this.analiseClienteService = analiseClienteService;
		this.logger = LoggerFactory.getLogger(NovaPropostaController.class);
	}


	// endpoint de criação de uma nova proposta - método POST
	@PostMapping(value = "/api/propostas")
	// realizando a conversão de classes direto no ponto de recebimento do
	// parâmetro que representa os dados da requisição
	public ResponseEntity<?> criaProposta(@Valid @RequestBody NovaPropostaRequest request,
			UriComponentsBuilder builder) { // protegendo a borda na entrada
		
		Optional<Proposta> response = propostaRepository.findByDocumento(request.getDocumento());
		
		if(response.isPresent()) {
			logger.warn("[Criação da Proposta] Tentativa de criação de proposta com o mesmo documento (CPF/CNPJ): " +request.getDocumento());
			
			return ResponseEntity.unprocessableEntity().body(new StandardError(Arrays.asList("Já existe uma proposta cadastrada com esse documento (CPF/CNPJ)")));
		}

		Proposta novaProposta = request.toModel(); // toModel comportamento para criar uma nova Proposta
		propostaRepository.save(novaProposta);

		logger.info("[Criação da Proposta] Proposta criada com sucesso: " + novaProposta.toString());
		
		analiseClienteService.processarAnaliseDaProposta(novaProposta);
		propostaRepository.save(novaProposta);
		
		logger.info("[Análise Financeira] Análise da proposta do Cliente realizada: " +novaProposta.toString());

		URI enderecoConsulta = builder.path("/api/propostas/{id}").build(novaProposta.getId());
		return ResponseEntity.created(enderecoConsulta).build();

	}

}

/*
 * ResponseEntity: essa classe serve para passar todas as informações da
 * requisição HTTP ResponseEntity.created nos retorna o status 201
 * 
 * UriComponentsBuilder: classe utilitária que ajuda a criar URIS essa classe
 * nos ajuda a lidar com problemas comuns de encodings presentes nas URIS
 */