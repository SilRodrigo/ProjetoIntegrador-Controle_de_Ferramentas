package com.model.service;

import com.model.dao.TipoObjetoDao;
import com.model.entity.TipoObjeto;
import java.util.ArrayList;
import java.util.List;

public class TipoObjetoService {

  TipoObjetoDao tipoObjetoDao = new TipoObjetoDao();

  public void insert(String type) {
    TipoObjeto tipoObjeto = new TipoObjeto(
      tipoObjetoDao.getLastIndex() + 1,
      type
    );
    tipoObjetoDao.insert(tipoObjeto);
  }

  public TipoObjeto getById(int id) {
    for (TipoObjeto tipoObjeto : tipoObjetoDao.getAll()) {
      if (tipoObjeto.getId() == id) return tipoObjeto;
    }
    return null;
  }

  public List<String> getAllData() {
    List<TipoObjeto> tipoObjetos = tipoObjetoDao.getAll();
    List<String> tipoObjetoList = new ArrayList<>();
    tipoObjetoList.add("id;Tipo");
    if (tipoObjetos == null) return tipoObjetoList;
    for (TipoObjeto tipoObjeto : tipoObjetos) {
      tipoObjetoList.add(tipoObjeto.getId() + ";" + tipoObjeto.getType());
    }
    return tipoObjetoList;
  }
}
