package com.fullcycle.application.product.service;

import com.fullcycle.application.product.entity.ProductInterface;

import java.math.BigDecimal;
import java.util.UUID;

public interface ProductServiceInterface {
  ProductInterface get(UUID id);
  ProductInterface create(String name, BigDecimal price);
  void enable(ProductInterface product);
  void disable(ProductInterface product);
}
