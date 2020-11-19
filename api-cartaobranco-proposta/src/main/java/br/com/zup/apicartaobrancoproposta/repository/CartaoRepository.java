package br.com.zup.apicartaobrancoproposta.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.apicartaobrancoproposta.model.Cartao;

public interface CartaoRepository extends CrudRepository<Cartao, UUID> {

}
