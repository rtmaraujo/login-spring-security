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

import br.com.exemplo.model.Cliente;
import br.com.exemplo.repository.ClienteRepository;

/**
 * 
 * @author Marcos Araujo
 *
 */
@RestController
@RequestMapping("/clientes")
public class ClienteEndpoint {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping
	public Cliente adicionarCliente(@Valid @RequestBody Cliente cliente, HttpServletRequest request) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> alterarCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		Cliente existeCliente = clienteRepository.findOne(id);
		if (existeCliente == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(cliente, existeCliente, "id");
		existeCliente = clienteRepository.save(existeCliente);
		return ResponseEntity.ok(existeCliente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> consultarCliente(@PathVariable Long id) {
		Cliente cliente = clienteRepository.findOne(id);
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerCliente(@PathVariable Long id) {
		Cliente cliente = clienteRepository.findOne(id);
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		}
		
		clienteRepository.delete(cliente);
		return ResponseEntity.ok().build();
	}
	
}
