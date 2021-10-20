package com.model.entity;

public class Objeto {

  int id;
  String name;
  TipoObjeto objectType;
  boolean borrowed;
  boolean inMaintenance;

  public Objeto(
    int id,
    String name,
    TipoObjeto objectType,
    boolean borrowed,
    boolean inMaintenance
  ) {
    this.id = id;
    this.name = name;
    this.objectType = objectType;
    this.borrowed = borrowed;
    this.inMaintenance = inMaintenance;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public TipoObjeto getObjectType() {
    return objectType;
  }

  public boolean isBorrowed() {
    return borrowed;
  }

  public boolean isInMaintenance() {
    return inMaintenance;
  }
}
