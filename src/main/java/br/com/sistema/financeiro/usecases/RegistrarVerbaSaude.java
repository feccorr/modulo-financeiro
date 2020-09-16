package br.com.sistema.financeiro.usecases;

import br.com.sistema.financeiro.domains.CasosPorRegiao;
import br.com.sistema.financeiro.domains.Covid19;
import br.com.sistema.financeiro.domains.VerbaSaude;
import br.com.sistema.financeiro.gateways.Covid19DatabaseGateway;
import br.com.sistema.financeiro.gateways.VerbaSaudeDatabaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Component
@RequiredArgsConstructor
public class RegistrarVerbaSaude {

  private final VerbaSaudeDatabaseGateway verbaSaudeDatabaseGateway;
  private final Covid19DatabaseGateway covid19DatabaseGateway;

  public void execute(final VerbaSaude verbaSaude) {
    verbaSaudeDatabaseGateway.save(verbaSaude);
  }

  public List<Covid19> listarCovidPorData(final LocalDate date){
    return covid19DatabaseGateway.listarCovidPorData(date);
  }

  public Map<String, Long> listarCasosPorRegiao(List<Covid19> lista){
    Map<String, Long> map = lista.stream()
            .collect(groupingBy(Covid19::getRegiao,
                    summingLong(Covid19::getQuantidade)));
    return map;
  }

}