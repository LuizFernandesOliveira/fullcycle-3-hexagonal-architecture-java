package com.fullcycle.application.product.entity;

import com.fullcycle.application.product.factory.ProductFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

  @Test
  void should_validate() {
    var product = ProductFactory.create();

    assertThrows(IllegalArgumentException.class, product::validate).getMessage().equals("the name is required");

    product.setName("Test");

    assertThrows(IllegalArgumentException.class, product::validate).getMessage().equals("the price is required");

    product.setPrice(BigDecimal.ZERO);

    assertThrows(IllegalArgumentException.class, product::validate).getMessage().equals("the price must be greater or equal than zero");

    product.setPrice(BigDecimal.valueOf(1));

    assertDoesNotThrow(product::validate);
  }

  @Test
  void should_enable() {
    var product = ProductFactory.create();
    product.setName("Test");
    product.setPrice(BigDecimal.valueOf(1));
    product.enable();

    assertEquals(Status.ENABLED, product.getStatus());
  }

  @Test
  void should_disable() {
    var product = ProductFactory.create();
    product.setName("Test");
    product.setPrice(BigDecimal.valueOf(1));
    product.disable();

    assertEquals(Status.DISABLED, product.getStatus());
  }
}