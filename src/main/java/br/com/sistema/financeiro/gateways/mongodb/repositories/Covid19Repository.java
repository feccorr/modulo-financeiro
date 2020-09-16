package br.com.sistema.financeiro.gateways.mongodb.repositories;

import br.com.sistema.financeiro.domains.Covid19;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface Covid19Repository extends MongoRepository<Covid19, String> {

    @Query("{ 'data' : ?0 }")
    List<Covid19> listarCovidPorData(LocalDate date);

}