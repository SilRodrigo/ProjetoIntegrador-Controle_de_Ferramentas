package com.model.dao;

import com.model.entity.User;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

  List<User> users;

  public UserDao() {
    this.users = getAllUsers();
  }

  public User find(String userName) {
    for (User user : this.users) {
      if (user.getName().equals(userName)) {
        return user;
      }
    }
    return null;
  }

  public void create(String userName) {}

  private List<User> getAllUsers() {
    List<User> users = new ArrayList<User>();
    String name = "Default";
    users.add(new User(name));
    return users;
  }
}
