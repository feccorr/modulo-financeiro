package br.com.sistema.financeiro.gateways.http;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import br.com.sistema.financeiro.gateways.http.resource.VerbaSaudeResource;
import br.com.sistema.financeiro.usecases.RegistrarVerbaSaude;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/verba-saude")
public class VerbaSaudeController {

  private final RegistrarVerbaSaude registrarVerbaSaude;

  @PostMapping(produces = APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Registrar verba para saúde")
  @ResponseStatus(OK)
  public ResponseEntity registrarVerbaSaude(
      @RequestBody @Valid final VerbaSaudeResource verbaSaudeResource) {
    registrarVerbaSaude.execute(verbaSaudeResource.toDomain());
    return ResponseEntity.ok().build();
  }
}