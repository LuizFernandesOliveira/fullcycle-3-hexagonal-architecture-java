package com.fullcycle.application.product.persistence;

import com.fullcycle.application.product.entity.ProductInterface;

import java.util.UUID;

public interface ProductPersistenceInterface {
  ProductInterface get(UUID id);
  ProductInterface save(ProductInterface product);
}
