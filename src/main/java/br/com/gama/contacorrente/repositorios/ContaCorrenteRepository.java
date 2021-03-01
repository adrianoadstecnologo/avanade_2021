package br.com.gama.contacorrente.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gama.contacorrente.entidades.ContaCorrente;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, UUID> {

}
