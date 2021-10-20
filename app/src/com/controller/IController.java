package com.controller;

import java.util.List;

public interface IController {
  public String[] requestInsert();

  public List<String> getAll();

  public String insert(List<String> list);

  public String delete();

  public String getControllerBaseName();
}
