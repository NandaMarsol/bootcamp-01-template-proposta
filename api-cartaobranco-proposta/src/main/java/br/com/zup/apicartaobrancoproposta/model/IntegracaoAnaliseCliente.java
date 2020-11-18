package br.com.zup.apicartaobrancoproposta.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.zup.apicartaobrancoproposta.request.AnaliseClienteRequest;
import br.com.zup.apicartaobrancoproposta.response.AnaliseClienteResponse;

/*
 * Cliente HTTP para o Serviço de Análise
 */

// anotação @FeignClient define o nome do cliente http que estamos criando
@FeignClient(url = "${integracao-analise-cliente.url}", name = "integracao")
public interface IntegracaoAnaliseCliente {
	
	// requisição para análise dos dados financeiros do solicitante - verifica se possui restrições
	@PostMapping(value = "/api/solicitacao")
	AnaliseClienteResponse analisePropostaCliente(@RequestBody AnaliseClienteRequest request);

}
