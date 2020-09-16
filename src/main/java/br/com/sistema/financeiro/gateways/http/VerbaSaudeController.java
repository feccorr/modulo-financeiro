package br.com.sistema.financeiro.gateways.http;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import br.com.sistema.financeiro.domains.CasosPorRegiao;
import br.com.sistema.financeiro.domains.Covid19;
import br.com.sistema.financeiro.gateways.http.resource.VerbaSaudeResource;
import br.com.sistema.financeiro.usecases.RegistrarVerbaSaude;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/verba-saude")
public class VerbaSaudeController {

  private final RegistrarVerbaSaude registrarVerbaSaude;

  @PostMapping(produces = APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Registrar verba para saúde covid19")
  @ResponseStatus(OK)
  public ResponseEntity registrarVerbaSaude(
      @RequestBody @Valid final VerbaSaudeResource verbaSaudeResource) {
    registrarVerbaSaude.execute(verbaSaudeResource.toDomain());
    return ResponseEntity.ok().build();
  }


  @GetMapping(produces = APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Distribuir verba para saúde covid19")
  @ResponseStatus(OK)
  public List<CasosPorRegiao> distribuirVerba(
          @RequestParam @Valid LocalDate data,
          @RequestParam @Valid Double valor) {
    List<Covid19> listaCovid =  registrarVerbaSaude.listarCovidPorData(data);

    Map<String, Long> casosPorRegiao = registrarVerbaSaude.listarCasosPorRegiao(listaCovid);

    Long somaTotalCasos = casosPorRegiao.values().stream().mapToLong(i->i).sum();

    List<CasosPorRegiao> casosRegiao =  new ArrayList<>();

    casosPorRegiao.forEach((key, value) -> {
      CasosPorRegiao caso = new CasosPorRegiao();
      caso.setRegiao(key);
      caso.setQuantidade((long) ((value*valor)/somaTotalCasos));
      casosRegiao.add(caso);
    });

    return casosRegiao;

  }
}