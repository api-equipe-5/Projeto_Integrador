package easyata.projetoapi.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport
@SpringBootApplication
public class ProjetoApiEasyAtaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApiEasyAtaApplication.class, args);
	}

}
