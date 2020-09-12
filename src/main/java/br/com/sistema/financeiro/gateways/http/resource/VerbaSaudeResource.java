package br.com.sistema.financeiro.gateways.http.resource;

import br.com.sistema.financeiro.domains.VerbaSaude;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerbaSaudeResource {

  @NotNull
  private Double valor;

  public VerbaSaude toDomain() {
    final VerbaSaude verbaSaude = new VerbaSaude();
    verbaSaude.setValor(valor);
    return verbaSaude;
  }
}