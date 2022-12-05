package com.fullcycle.application.product.entity;

import java.util.Set;

public enum Status {
  ENABLED,
  DISABLED;

  public static Set<Status> ALL = Set.of(ENABLED, DISABLED);
}
