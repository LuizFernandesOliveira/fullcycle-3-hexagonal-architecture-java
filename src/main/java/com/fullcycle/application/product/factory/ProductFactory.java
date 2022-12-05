package com.fullcycle.application.product.factory;


import com.fullcycle.application.product.entity.Product;
import com.fullcycle.application.product.entity.Status;

import java.util.UUID;

public class ProductFactory {

  public static Product create() {
    return new Product(UUID.randomUUID(), Status.DISABLED);
  }
}
