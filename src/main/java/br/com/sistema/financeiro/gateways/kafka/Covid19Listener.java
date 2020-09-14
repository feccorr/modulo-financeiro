package br.com.sistema.financeiro.gateways.kafka;

import br.com.sistema.financeiro.gateways.Covid19DatabaseGateway;
import br.com.sistema.financeiro.gateways.kafka.resource.Covid19Resource;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Covid19Listener {

  private final ObjectMapper objectMapper;

  private final Covid19DatabaseGateway covid19DatabaseGateway;

  // Consumuindo o topico saude-covid
  @KafkaListener(topics = "saude-covid-input")
  public void lerMensagem(final String mensagem) {
    final Covid19Resource covid19Resource = converterMensagem(mensagem);
    covid19DatabaseGateway.save(covid19Resource.toDomain());
  }

  private Covid19Resource converterMensagem(String mensagem) {
    try {
      return objectMapper.readValue(mensagem, Covid19Resource.class);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}