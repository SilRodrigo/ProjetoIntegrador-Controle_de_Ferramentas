package com.model.entity;

public class Manutencao {

  int id;
  String name;

  public Manutencao(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
      return id;
  }

  public String getName() {
      return name;
  }
}
