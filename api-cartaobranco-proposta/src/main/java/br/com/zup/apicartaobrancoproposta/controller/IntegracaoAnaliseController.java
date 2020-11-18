package br.com.zup.apicartaobrancoproposta.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.apicartaobrancoproposta.request.AnaliseClienteRequest;

@RestController
public class IntegracaoAnaliseController {
	
	private AtomicInteger contDocumentos = new AtomicInteger();
	
	@PostMapping(value = "/api/avaliacao")
	public String avaliaDocumento(@RequestBody AnaliseClienteRequest request) {
		int contAtual = contDocumentos.getAndIncrement();
		if(contAtual % 2 != 0) {
			return "COM_RESTRICAO";
		}
		
		return "SEM_RESTRICAO";
		
	}

}
