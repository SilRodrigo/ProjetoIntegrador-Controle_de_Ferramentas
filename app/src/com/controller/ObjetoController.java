package com.controller;

import com.model.entity.TipoObjeto;
import com.model.service.ObjetoService;
import com.model.service.TipoObjetoService;
import com.util.Texting;
import java.util.List;

public class ObjetoController implements IController {

  ObjetoService objetoService = new ObjetoService();
  TipoObjetoService TipoObjetoService = new TipoObjetoService();

  @Override
  public List<String> getAll() {
    return objetoService.getAllData();
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
      TipoObjeto tipoObjeto = TipoObjetoService.getById(
        Integer.parseInt(list.get(1))
      );
      if (tipoObjeto == null) throw new Exception();
      objetoService.insert(list.get(0), tipoObjeto, false, false);
      return Texting.registerSuccessful;
    } catch (Exception e) {
      return Texting.registerFailure;
    }
  }

  @Override
  public String getControllerBaseName() {
    return "Objeto";
  }
}
