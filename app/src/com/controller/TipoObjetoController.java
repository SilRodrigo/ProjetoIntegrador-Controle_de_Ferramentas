package com.controller;

import com.model.service.TipoObjetoService;
import java.util.List;

public class TipoObjetoController implements IController {

  TipoObjetoService tipoObjetoService = new TipoObjetoService();

  public List<String> getAll() {
    return tipoObjetoService.getAllData();
  }

  @Override
  public String[] requestInsert() {
    String fields = this.getAll().get(0);
    return fields.split(";");
  }

  @Override
  public String delete() {
    return null;
  }

  @Override
  public String insert(List<String> list) {
    try {
      tipoObjetoService.insert(list.get(0));
      return "\nCadastrado com sucesso!";
    } catch (Exception e) {
      return "\nDados Invalidos para cadastro!";
    }
  }

  @Override
  public String getControllerBaseName() {
    return "TipoObjeto";
  }
}
