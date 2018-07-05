package br.com.exemplo.endpoint;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.model.Carro;
import br.com.exemplo.repository.CarroRepository;

/**
 * 
 * @author Marcos Araujo
 *
 */
@RestController
@RequestMapping("/carros")
public class CarroEndpoint {

	@Autowired
	private CarroRepository carroRepository;

	@PostMapping
	public Carro adicionarCarro(@Valid @RequestBody Carro carro, HttpServletRequest request) {
		return carroRepository.save(carro);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Carro> alterarCarro(@PathVariable Long id, @Valid @RequestBody Carro carro) {
		Carro existeCarro = carroRepository.findOne(id);
		if (existeCarro == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(carro, existeCarro, "id");
		existeCarro = carroRepository.save(existeCarro);
		return ResponseEntity.ok(existeCarro);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Carro> consultarCarro(@PathVariable Long id) {
		Carro carro = carroRepository.findOne(id);
		if (carro == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(carro);
	}

	@GetMapping
	public List<Carro> listar() {
		return carroRepository.findAll();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerCarro(@PathVariable Long id) {
		Carro carro = carroRepository.findOne(id);
		if (carro == null) {
			return ResponseEntity.notFound().build();
		}
		carroRepository.delete(carro);
		return ResponseEntity.ok().build();
	}

}
