package com.model.entity;

public class Cliente{

  int id;
  String name;
  String address;
  int addressNumber;

  public Cliente(int id, String name, String address, int addressNumber) {
    this.id = id;
    this.name = name.toUpperCase();
    this.address = address.toUpperCase();
    this.addressNumber = addressNumber;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public int getAddressNumber() {
    return addressNumber;
  }
}
