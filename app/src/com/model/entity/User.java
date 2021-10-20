package com.model.entity;

public class User {

  boolean logged;
  String name;

  public User(String userName) {
    this.name = userName;
    this.logged = true;;
  }

  public String getName() {
    return name;
  }

  public Boolean getLogged(){
    return logged;
  }

  public void setLogged(boolean logged) {
      this.logged = logged;
  }
}
