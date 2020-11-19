package br.com.zup.apicartaobrancoproposta.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.apicartaobrancoproposta.model.Proposta;
import br.com.zup.apicartaobrancoproposta.model.StatusDaProposta;

public interface PropostaRepository extends CrudRepository<Proposta, UUID> {

	Optional<Proposta> findByDocumento(String documento);

	List<Proposta> findByStatusDaProposta(StatusDaProposta statusDaProposta);
}
