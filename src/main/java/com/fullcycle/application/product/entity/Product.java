package com.fullcycle.application.product.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class Product implements ProductInterface {
  private UUID id;
  private String name;
  private BigDecimal price;
  private Status status;

  public Product(UUID id, Status status) {
    this.id = id;
    this.status = status;
  }

  public void validate() {
    if (this.status == null) {
      this.status = Status.DISABLED;
    }

    if (this.name == null) {
      throw new IllegalArgumentException("the name is required");
    }

    if (this.price == null) {
      throw new IllegalArgumentException("the price is required");
    }

    if (BigDecimal.ZERO.compareTo(this.price) >= 0) {
      throw new IllegalArgumentException("the price must be greater or equal than zero");
    }
  }

  public void enable() {
    this.status = Status.ENABLED;
  }

  public void disable() {
    this.status = Status.DISABLED;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public Status getStatus() {
    return status;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
