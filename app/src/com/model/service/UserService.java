package com.model.service;

import com.model.dao.UserDao;
import com.model.entity.User;

public class UserService {

  User user;
  UserDao userDao = new UserDao();

  public UserService(String userName) {
    this.user = new User(userName);
  }

  public String getName() {
    return user.getName();
  }

  public Boolean getLogged() {
    return user.getLogged();
  }

  public void setLogged(Boolean logged) {
    user.setLogged(logged);
  }
}
