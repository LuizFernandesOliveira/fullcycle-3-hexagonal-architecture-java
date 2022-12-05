package com.fullcycle.application.product.entity;

import java.math.BigDecimal;
import java.util.UUID;

public interface ProductInterface {
  UUID getId();
  String getName();
  BigDecimal getPrice();
  Status getStatus();
  void enable();
  void disable();
  void validate();
}
