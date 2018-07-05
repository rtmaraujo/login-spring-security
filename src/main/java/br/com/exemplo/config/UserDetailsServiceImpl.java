package br.com.exemplo.config;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.exemplo.model.Usuario;
import br.com.exemplo.repository.UsuarioRepository;

/**
 * 
 * @author Marcos Araujo
 *
 */
@Repository
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByLogin(login);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}

}
