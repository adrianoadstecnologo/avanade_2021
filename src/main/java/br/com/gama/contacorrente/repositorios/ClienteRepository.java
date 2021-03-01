package br.com.gama.contacorrente.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gama.contacorrente.entidades.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
	
	Cliente findByContas_Id(UUID id);
}
