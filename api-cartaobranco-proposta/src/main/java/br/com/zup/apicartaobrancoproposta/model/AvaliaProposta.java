package br.com.zup.apicartaobrancoproposta.model;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.zup.apicartaobrancoproposta.request.NovoDocumentoRequest;

@Validated
@Service
public class AvaliaProposta {
	
	@Autowired
	private IntegracaoAnaliseCliente integracao;
	
	public StatusAvaliacao executa(@NotNull Proposta proposta) {
		String resultadoAvaliacao = integracao.avaliaProposta(new NovoDocumentoRequest(proposta));
		return RespostaStatusAvaliacao.valueOf(resultadoAvaliacao).getStatusAvaliacao();
	}


}
