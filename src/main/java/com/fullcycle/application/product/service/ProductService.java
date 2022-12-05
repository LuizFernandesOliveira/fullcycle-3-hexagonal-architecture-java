package com.fullcycle.application.product.service;

import com.fullcycle.application.product.entity.ProductInterface;
import com.fullcycle.application.product.factory.ProductFactory;
import com.fullcycle.application.product.persistence.ProductPersistenceInterface;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public class ProductService implements ProductServiceInterface {
  private ProductPersistenceInterface persistence;

  public ProductService(ProductPersistenceInterface persistence) {
    this.persistence = persistence;
  }

  @Override
  public ProductInterface get(UUID id) {
    return Optional.ofNullable(this.persistence.get(id)).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public ProductInterface create(String name, BigDecimal price) {
    var product = ProductFactory.create();
    product.setName(name);
    product.setPrice(price);
    product.validate();
    return this.persistence.save(product);
  }

  @Override
  public void enable(ProductInterface product) {
    product.enable();
    this.persistence.save(product);
  }

  @Override
  public void disable(ProductInterface product) {
    product.disable();
    this.persistence.save(product);
  }
}
