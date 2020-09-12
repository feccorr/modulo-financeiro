package br.com.sistema.financeiro.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("verbaSaude")
public class VerbaSaude {

  @Id
  private String id;
  private Double valor;
}