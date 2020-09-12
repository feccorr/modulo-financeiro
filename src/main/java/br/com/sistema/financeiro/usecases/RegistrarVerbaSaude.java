package br.com.sistema.financeiro.usecases;

import br.com.sistema.financeiro.domains.VerbaSaude;
import br.com.sistema.financeiro.gateways.VerbaSaudeDatabaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistrarVerbaSaude {

  private final VerbaSaudeDatabaseGateway verbaSaudeDatabaseGateway;

  public void execute(final VerbaSaude verbaSaude) {
    verbaSaudeDatabaseGateway.save(verbaSaude);
  }
}