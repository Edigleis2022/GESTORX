package br.ifms.edu.GestaorX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GestaorXApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaorXApplication.class, args);
	}

	
	@GetMapping("/olamundo")	
	public ResponseEntity<String> olamundo() {
		return ResponseEntity.ok("Ola Mundo aqui estou eu de novo!");
	}

}
