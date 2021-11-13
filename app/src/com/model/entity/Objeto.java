package com.model.entity;

public class Objeto {

  int id;
  String name;
  int objectTypeId;
  boolean borrowed;
  boolean inMaintenance;
  boolean status;

  public Objeto(
    int id,
    String name,
    int objectTypeId,
    boolean borrowed,
    boolean inMaintenance,
    boolean status
  ) {
    this.id = id;
    this.name = name.toUpperCase();
    this.objectTypeId = objectTypeId;
    this.borrowed = borrowed;
    this.inMaintenance = inMaintenance;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getObjectTypeId() {
    return objectTypeId;
  }

  public boolean isBorrowed() {
    return borrowed;
  }

  public boolean isInMaintenance() {
    return inMaintenance;
  }

  public boolean getStatus(){
    return status;
  }
}
