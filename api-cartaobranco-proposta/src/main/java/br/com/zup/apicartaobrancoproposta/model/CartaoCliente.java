package br.com.zup.apicartaobrancoproposta.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

	@FeignClient(name = "cartao", url = "${host.cartao}") // @FeignClient - define o nome do cliente que estamos criando
	public interface CartaoCliente {
		
		@GetMapping("/api/cartoes")
		Cartao buscarCartaoPorIdProposta(@RequestParam("idProposta") String idProposta);
	}



