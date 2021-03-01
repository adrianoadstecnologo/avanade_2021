package br.com.gama.contacorrente.repositorios;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.gama.contacorrente.entidades.Operacao;

public interface OperacaoRepository extends MongoRepository<Operacao, String>{

	List<Operacao> findByContaId(String id);
}
