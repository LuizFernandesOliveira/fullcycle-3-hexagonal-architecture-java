package com.fullcycle.adapters.cli.jbang;

public enum CLIOption {
  CREATE("create"),
  UPDATE("update"),
  GET("get");

  private final String value;

  CLIOption(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
