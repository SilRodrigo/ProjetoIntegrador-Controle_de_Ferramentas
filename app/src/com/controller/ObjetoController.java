package com.controller;

import com.model.entity.Objeto;
import com.model.service.ObjetoService;
import com.util.Texting;
import java.util.List;

public class ObjetoController implements IController {

  ObjetoService objetoService = new ObjetoService();

  @Override
  public List<String> getAll() {
    return objetoService.getAllData();
  }

  @Override
  public List<String> getAvailable() {
    return objetoService.getAvailable();
  }

  public List<String> getInsertRequiredOnly() {
    return objetoService.getInsertRequiredOnly();
  }

  @Override
  public String[] requestInsert() {
    String fields = this.getInsertRequiredOnly().get(0);
    return fields.split(";");
  }

  @Override
  public String delete() {
    return null;
  }

  @Override
  public String insert(List<String> list) {
    try {
      objetoService.insert(
        list.get(1),
        Integer.parseInt(list.get(0)),
        false,
        false,
        true
      );
      return Texting.registerSuccessful;
    } catch (Exception e) {
      System.out.println(e);
      return Texting.registerFailure;
    }
  }

  @Override
  public String getControllerBaseName() {
    return "Objeto";
  }

  @Override
  public boolean findId(int id) {
    Objeto objeto = this.objetoService.getById(id);
    if (objeto == null) {
      System.out.println("\nNao existe esse Id cadastrado!");
      Entrada.leiaString("Aperte ENTER para continuar...");
      return false;
    }
    return true;
  }

  @Override
  public List<String> requestEdit(int id) {
    return objetoService.requestEdit(id);
  }

  @Override
  public boolean update(int id, int index, String newValue) {
    try {
      objetoService.update(id, index, newValue);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
