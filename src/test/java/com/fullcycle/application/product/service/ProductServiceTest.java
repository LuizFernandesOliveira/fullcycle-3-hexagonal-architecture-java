package com.fullcycle.application.product.service;

import com.fullcycle.application.product.entity.Product;
import com.fullcycle.application.product.entity.Status;
import com.fullcycle.application.product.factory.ProductFactory;
import com.fullcycle.application.product.persistence.ProductPersistenceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class ProductServiceTest {
  private ProductPersistenceInterface persistence;
  private ProductService service;

  @BeforeEach
  void setup() {
    this.persistence = Mockito.mock(ProductPersistenceInterface.class);
    this.service = new ProductService(persistence);
  }

  @Test
  void should_get() {
    var product = ProductFactory.create();
    product.setName("Test");
    product.setPrice(BigDecimal.valueOf(1));

    given(persistence.get(product.getId())).willReturn(product);
    var result = service.get(product.getId());
    assertEquals(product, result);
  }

  @Test
  void should_throw_when_get() {
    var product = ProductFactory.create();
    product.setName("Test");
    product.setPrice(BigDecimal.valueOf(1));

    given(persistence.get(product.getId())).willReturn(null);

    assertThrows(NoSuchElementException.class, () -> service.get(product.getId()));
  }

  @Test
  void should_create() {
    var product = ProductFactory.create();
    product.setName("Test");
    product.setPrice(BigDecimal.valueOf(1));

    given(persistence.save(any(Product.class))).willReturn(product);
    var result = service.create(product.getName(), product.getPrice());
    assertEquals(product, result);
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