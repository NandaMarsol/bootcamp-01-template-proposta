package br.com.zup.apicartaobrancoproposta.request;

import br.com.zup.apicartaobrancoproposta.model.Proposta;

public class AnaliseClienteRequest {
	
	private String nome;
	private String documento;
	private String idProposta;
	
	@Deprecated
	public AnaliseClienteRequest(){		
	}
	
	public AnaliseClienteRequest(Proposta proposta) {
		this.nome = proposta.getNome();
		this.documento = proposta.getDocumento();
		this.idProposta = proposta.getId();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getIdProposta() {
		return idProposta;
	}

	public void setIdProposta(String idProposta) {
		this.idProposta = idProposta;
	}


}
