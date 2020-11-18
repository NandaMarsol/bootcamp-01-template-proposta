package br.com.zup.apicartaobrancoproposta.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.apicartaobrancoproposta.model.Proposta;

public interface PropostaRepository extends CrudRepository<Proposta, UUID> {
	
	Optional<Proposta> findByDocumento(String documento);

}
