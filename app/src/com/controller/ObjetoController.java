package com.controller;

import com.model.service.ObjetoService;
import com.util.Texting;
import java.util.List;

public class ObjetoController implements IController {

  ObjetoService objetoService = new ObjetoService();

  @Override
  public List<String> getAll() {
    return objetoService.getAllData();
  }

  public List<String> getAll(TipoObjetoController tipoObjetoController) {
    return objetoService.getAllData(tipoObjetoController.tipoObjetoService);
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
    // TODO Auto-generated method stub
    return false;
  }
}
