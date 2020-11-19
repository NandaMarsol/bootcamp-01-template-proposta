package br.com.zup.apicartaobrancoproposta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableFeignClients // indica para o Spring Framework que o projeto vai utilizar a configuração de clientes web services dinâmicas
@EnableScheduling // habilita a funcionalidade para agendamento de tarefas
@SpringBootApplication
public class ApiCartaobrancoPropostaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCartaobrancoPropostaApplication.class, args);
	}

}
