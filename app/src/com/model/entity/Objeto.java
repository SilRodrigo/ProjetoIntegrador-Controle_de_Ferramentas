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

  public void setName(String name) {
      this.name = name;
  }

  public void setObjectTypeId(int objectTypeId) {
      this.objectTypeId = objectTypeId;
  }

  public void setBorrowed(boolean borrowed) {
      this.borrowed = borrowed;
  }

  public void setInMaintenance(boolean inMaintenance) {
      this.inMaintenance = inMaintenance;
  }

  public void setStatus(boolean status) {
      this.status = status;
  }
}
