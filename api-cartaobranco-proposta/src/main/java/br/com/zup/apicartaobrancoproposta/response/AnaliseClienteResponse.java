package br.com.zup.apicartaobrancoproposta.response;

import java.util.UUID;

import br.com.zup.apicartaobrancoproposta.model.StatusDaProposta;

public class AnaliseClienteResponse {
	
	private String documento;
	private String nome;
	private StatusDaProposta resultadoSolicitacao;
	private UUID idProposta;
	
	
	public String getDocumento() {
		return documento;
	}
	public String getNome() {
		return nome;
	}
	public StatusDaProposta getResultadoSolicitacao() {
		return resultadoSolicitacao;
	}
	public UUID getIdProposta() {
		return idProposta;
	}

}
