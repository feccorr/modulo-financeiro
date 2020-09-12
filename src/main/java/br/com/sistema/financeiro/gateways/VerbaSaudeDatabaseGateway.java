package br.com.sistema.financeiro.gateways;

import br.com.sistema.financeiro.domains.VerbaSaude;

public interface VerbaSaudeDatabaseGateway {

  void save(VerbaSaude verbaSaude);
}