package br.com.sistema.financeiro.gateways.mongodb.repositories;

import br.com.sistema.financeiro.domains.Covid19;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Covid19Repository extends MongoRepository<Covid19, String> {

}