package br.com.exemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exemplo.model.Carro;

/**
 * 
 * @author Marcos Araujo
 *
 */

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
