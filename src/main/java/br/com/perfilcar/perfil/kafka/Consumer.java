package br.com.perfilcar.perfil.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
  @KafkaListener(id = "consumer", topics = "topicoLog")
  public void consumeMessage(String message) {
    System.out.println("Got message: " + message);
  }
}