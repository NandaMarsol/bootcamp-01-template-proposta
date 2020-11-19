package br.com.zup.apicartaobrancoproposta.model;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {

	@Id
	private UUID id;
	private LocalDateTime cartaoEmitidoEm;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getCartaoEmitidoEm() {
		return cartaoEmitidoEm;
	}

	public void setCartaoEmitidoEm(LocalDateTime cartaoEmitidoEm) {
		this.cartaoEmitidoEm = cartaoEmitidoEm;
	}

	@Override
	public String toString() {
		return "Cartao [id=" + id + ", cartaoEmitidoEm=" + cartaoEmitidoEm + "]";
	}

}
