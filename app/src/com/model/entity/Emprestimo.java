package com.model.entity;

public class Emprestimo {

  int id;
  int objetoId;
  int clienteId;
  String dateOut;
  String dateIn;
  boolean status;

  public Emprestimo(
    int id,
    int objetoId,
    int clienteId,
    String dateOut,
    String dateIn,
    boolean status
  ) {
    this.id = id;
    this.objetoId = objetoId;
    this.clienteId = clienteId;
    this.dateOut = dateOut;
    this.dateIn = dateIn;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public int getObjectId() {
    return objetoId;
  }

  public int getClienteId() {
    return clienteId;
  }

  public String getDateOut() {
    return dateOut;
  }

  public String getDateIn() {
    return dateIn;
  }

  public boolean getStatus() {
    return status;
  }
}
