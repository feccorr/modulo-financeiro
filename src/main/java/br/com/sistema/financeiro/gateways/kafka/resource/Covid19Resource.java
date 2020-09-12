package br.com.sistema.financeiro.gateways.kafka.resource;

import br.com.sistema.financeiro.domains.Covid19;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Covid19Resource {

  private String codigo;
  private String regiao;
  private Long quantidade;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate data;

  public Covid19 toDomain() {
    final Covid19 covid19 = new Covid19();
    covid19.setId(codigo);
    covid19.setRegiao(regiao);
    covid19.setQuantidade(quantidade);
    covid19.setData(data);
    return covid19;
  }
}