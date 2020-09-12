package br.com.sistema.financeiro.gateways;

import br.com.sistema.financeiro.domains.Covid19;

public interface Covid19DatabaseGateway {

  void save(Covid19 covid19);
}