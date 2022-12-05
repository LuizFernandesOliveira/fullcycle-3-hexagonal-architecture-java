package com.fullcycle.adapters.cli.jbang;

public class CLIService {
  public void execute(String option, String id, String name, String price) {
    var cliOption = CLIOption.valueOf(option.toUpperCase());
    switch (cliOption) {
      case CREATE -> create(id, name, price);
      case UPDATE -> update(id, name, price);
      case GET -> get(id);
      default -> throw new RuntimeException("Invalid option");
    }
  }

  private void create(String id, String name, String price) {
    System.out.println("Create");
  }

  private void update(String id, String name, String price) {
    System.out.println("Update");
  }

  private void get(String id) {
    System.out.println("Get");
  }
}
