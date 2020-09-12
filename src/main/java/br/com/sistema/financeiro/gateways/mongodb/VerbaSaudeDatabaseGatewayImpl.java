package br.com.sistema.financeiro.gateways.mongodb;

import br.com.sistema.financeiro.domains.VerbaSaude;
import br.com.sistema.financeiro.gateways.VerbaSaudeDatabaseGateway;
import br.com.sistema.financeiro.gateways.mongodb.repositories.VerbaSaudeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VerbaSaudeDatabaseGatewayImpl implements VerbaSaudeDatabaseGateway {

  private final VerbaSaudeRepository verbaSaudeRepository;

  @Override
  public void save(final VerbaSaude verbaSaude) {
    verbaSaudeRepository.save(verbaSaude);
  }
}