package br.com.zup.apicartaobrancoproposta.model;

public enum RespostaStatusAvaliacao {
	
	COM_RESTRICAO(StatusAvaliacao.nao_elegivel), SEM_RESTRICAO(StatusAvaliacao.elegivel);
	
	private StatusAvaliacao statusAvaliacao;
	
	// construtor
	private RespostaStatusAvaliacao(StatusAvaliacao statusAvaliacao) {
		this.statusAvaliacao = statusAvaliacao;
	}

	public StatusAvaliacao getStatusAvaliacao() {
		return statusAvaliacao;
	}
	

}
