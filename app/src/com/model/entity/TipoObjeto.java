package com.model.entity;

public class TipoObjeto {

  int id;
  String type;

  public TipoObjeto(int id, String type) {
    this.id = id;
    this.type = type.toUpperCase();
  }

  public int getId() {
      return id;
  }

  public String getType() {
      return type;
  }
}
