package br.com.exemplo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.exemplo.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	Usuario findByLogin(String login);
}
