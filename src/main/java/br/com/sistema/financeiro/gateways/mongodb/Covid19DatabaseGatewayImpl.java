package br.com.sistema.financeiro.gateways.mongodb;

import br.com.sistema.financeiro.domains.Covid19;
import br.com.sistema.financeiro.gateways.Covid19DatabaseGateway;
import br.com.sistema.financeiro.gateways.mongodb.repositories.Covid19Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Covid19DatabaseGatewayImpl implements Covid19DatabaseGateway {

  private final Covid19Repository covid19Repository;

  @Override
  public void save(final Covid19 covid19) {
    covid19Repository.save(covid19);
  }

  @Override
  public List<Covid19> listarCovidPorData(LocalDate date) {
    return covid19Repository.listarCovidPorData(date);
  }

  @Override
  public Double somarValorTotalVerba() {
    return null;
  }
}