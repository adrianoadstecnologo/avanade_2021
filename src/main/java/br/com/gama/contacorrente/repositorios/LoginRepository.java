package br.com.gama.contacorrente.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gama.contacorrente.entidades.Login;

public interface LoginRepository extends JpaRepository<Login, UUID>{

	Login findByUsuario(String usuario);
}
