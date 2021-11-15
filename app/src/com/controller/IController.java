package com.controller;

import java.util.List;

public interface IController {
  public String[] requestInsert();

  public List<String> getAll();

  public List<String> getAvailable();
  
  public boolean findId(int id);

  public String insert(List<String> list);

  public String delete();

  public String getControllerBaseName();
}
