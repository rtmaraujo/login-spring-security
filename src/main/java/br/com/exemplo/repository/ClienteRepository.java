package br.com.exemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exemplo.model.Cliente;

/**
 * 
 * @author Marcos Araujo
 *
 */

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
