package br.com.zup.apicartaobrancoproposta.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.zup.apicartaobrancoproposta.model.IntegracaoAnaliseCliente;
import br.com.zup.apicartaobrancoproposta.model.Proposta;
import br.com.zup.apicartaobrancoproposta.model.StatusDaProposta;
import br.com.zup.apicartaobrancoproposta.request.AnaliseClienteRequest;
import br.com.zup.apicartaobrancoproposta.response.AnaliseClienteResponse;

@Service
public class AnaliseClienteService {
	
	private IntegracaoAnaliseCliente integracaoAnaliseCliente;
	private AnaliseClienteRequest analiseClienteRequest;
	private AnaliseClienteResponse analiseClienteResponse;
	
	private Logger logger;

	public AnaliseClienteService(IntegracaoAnaliseCliente integracaoAnaliseCliente, Logger logger) {
		super();
		this.integracaoAnaliseCliente = integracaoAnaliseCliente;
		this.logger = LoggerFactory.getLogger(AnaliseClienteService.class);
	}
	
	public Proposta processarAnaliseDaProposta(Proposta proposta) {
		Assert.notNull(proposta, "A proposta não pode ser nula!");
		logger.info("[ANALISE FINANCEIRA] Processando a análise financeira da proposta: " +proposta.getId() + "[" +LocalDateTime.now()+ "]");
		analiseClienteRequest = new AnaliseClienteRequest(proposta);
		analiseClienteResponse = integracaoAnaliseCliente.analisePropostaCliente(analiseClienteRequest);
		
		StatusDaProposta status = analiseClienteResponse.getResultadoSolicitacao();
		proposta.atualizaStatusProposta(status);
		return proposta;

	}
		

}
