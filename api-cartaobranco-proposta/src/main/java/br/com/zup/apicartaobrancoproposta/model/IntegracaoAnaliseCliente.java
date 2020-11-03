package br.com.zup.apicartaobrancoproposta.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.zup.apicartaobrancoproposta.request.NovoDocumentoRequest;

// anotação @FeignClient define o nome do cliente que estamos criando
@FeignClient(url = "${enderecos-externos.base-url}", name = "integracao")
public interface IntegracaoAnaliseCliente {
	
	@PostMapping(value = "/api/solicitacao")
	public String avaliaProposta(NovoDocumentoRequest request);
	

}
