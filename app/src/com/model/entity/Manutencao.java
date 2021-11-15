package com.model.entity;

public class Manutencao {

  int id;
  String name;
  int objetoId;
  boolean status;

  public Manutencao(int id, String name, int objetoId) {
    this.id = id;
    this.name = name;
    this.objetoId = objetoId;
  }

  public int getId() {
      return id;
  }

  public String getName() {
      return name;
  }

  public int getObjetoId() {
      return objetoId;
  }

  public boolean getStatus() {
      return status;
  }
}
