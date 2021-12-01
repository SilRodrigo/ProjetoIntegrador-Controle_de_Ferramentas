package com.controller;

import java.util.List;

public interface IController {
  public String[] requestInsert();

  public List<String> getAll();

  public List<String> getAvailable();

  public List<String> requestEdit(int id);

  public boolean findId(int id);

  public String insert(List<String> list);

  public boolean update(int id, int index, String newValue);

  public String delete();

  public String getControllerBaseName();
}
