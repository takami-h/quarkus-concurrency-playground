package com.natswell.examples;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.arc.Lock;

@ApplicationScoped
public class Greeter {
  static final Logger LOGGER = Logger.getLogger(Greeter.class.getName());

  // https://quarkus.io/guides/cdi-reference#container-managed-concurrency
  @Lock
  public String greetSerial() {
    return greet();
  }

  public String greet() {
    try {
      LOGGER.info("greeting...");
      TimeUnit.SECONDS.sleep(3L);
      return "Hello World";
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }
}
