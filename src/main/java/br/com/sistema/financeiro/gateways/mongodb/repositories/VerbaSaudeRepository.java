package br.com.sistema.financeiro.gateways.mongodb.repositories;

import br.com.sistema.financeiro.domains.VerbaSaude;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VerbaSaudeRepository extends MongoRepository<VerbaSaude, String> {

}