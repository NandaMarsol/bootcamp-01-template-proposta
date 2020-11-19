package br.com.zup.apicartaobrancoproposta.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import br.com.zup.apicartaobrancoproposta.model.Cartao;
import br.com.zup.apicartaobrancoproposta.model.CartaoCliente;
import br.com.zup.apicartaobrancoproposta.model.Proposta;
import br.com.zup.apicartaobrancoproposta.model.StatusDaProposta;
import br.com.zup.apicartaobrancoproposta.repository.CartaoRepository;
import br.com.zup.apicartaobrancoproposta.repository.PropostaRepository;

@Component // informando para o Spring que está classe é uma tarefa
public class CartaoService {

	private CartaoCliente cartaoCliente;
	private PropostaRepository propostaRepository;
	private CartaoRepository cartaoRepository;
	private Logger logger;

	public CartaoService(CartaoCliente cartaoCliente, PropostaRepository propostaRepository,
			CartaoRepository cartaoRepository) {
		super();
		this.cartaoCliente = cartaoCliente;
		this.propostaRepository = propostaRepository;
		this.cartaoRepository = cartaoRepository;
		this.logger = LoggerFactory.getLogger(CartaoService.class);
	}

	@Scheduled(fixedDelay = 5000) // @Scheduled - indicando para o Spring que esse método será agendado
	public void buscarExisteCartaoCadastradoProposta() {
		logger.info("[SCHEDULED] Buscar se existe um cartão cadastrado na proposta [ " + LocalDateTime.now() + "]");

		List<Proposta> propostas = propostaRepository.findByStatusDaProposta(StatusDaProposta.ELEGIVEL);

		propostas.forEach(proposta -> {
			Cartao cartao = cartaoCliente.buscarCartaoPorIdProposta(proposta.getId().toString());

			if (proposta.buscarSeNaoExisteCartao()) {
				Assert.notNull(cartao, "O cartão não pode ser nulo! ");
				cartaoRepository.save(cartao);
				proposta.incluirCartaoNaProposta(cartao);
				propostaRepository.save(proposta);
				logger.info("[INCLUSÃO DE CARTÃO NA PROPOSTA] Cartão incluso na proposta: " + proposta.toString());
			}
		});
	}

}
