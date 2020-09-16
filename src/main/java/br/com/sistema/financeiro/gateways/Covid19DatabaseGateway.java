package br.com.sistema.financeiro.gateways;

import br.com.sistema.financeiro.domains.Covid19;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface Covid19DatabaseGateway {

  void save(Covid19 covid19);

  List<Covid19> listarCovidPorData(LocalDate date);

  Double somarValorTotalVerba();

}