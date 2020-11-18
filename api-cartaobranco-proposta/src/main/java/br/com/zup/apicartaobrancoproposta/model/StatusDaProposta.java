package br.com.zup.apicartaobrancoproposta.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusDaProposta {
	
	ELEGIVEL("SEM_RESTRICAO"), // nenhuma restrição do cliente na solicitação da proposta
	NAO_ELEGIVEL("COM_RESTRICAO"); // restrição encontrada na solicitação da proposta para esse cliente
	
	String restricao;

	StatusDaProposta(String restricao) {
		this.restricao = restricao;
	}

	@JsonValue
	public String getRestricao() {
		return restricao;
	}

}
