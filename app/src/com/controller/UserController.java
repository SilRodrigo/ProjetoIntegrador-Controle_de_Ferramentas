package com.controller;

import com.model.service.UserService;

public class UserController {

  private UserService userService;

  public UserController(String userName) {
    this.userService = new UserService(userName);
  }

  public String getName() {
    return this.userService.getName();
  }

  public Boolean getLogged() {
    return userService.getLogged();
  }

  public void setLogged(Boolean logged) {
    userService.setLogged(logged);
  }
}
