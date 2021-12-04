package com.model.service;

import com.model.dao.TipoObjetoDao;
import com.model.entity.TipoObjeto;
import java.util.ArrayList;
import java.util.List;

public class TipoObjetoService {

  TipoObjetoDao tipoObjetoDao = new TipoObjetoDao();
  final String INDEX_LIST = ("Tipo");
  final String ID = "id;";

  public void insert(String type) {
    TipoObjeto tipoObjeto = new TipoObjeto(
      tipoObjetoDao.getLastIndex() + 1,
      type
    );
    tipoObjetoDao.insert(tipoObjeto);
  }

  public void update(int id, int index, String newValue) throws Exception {
    TipoObjeto tipoObjeto = getById(id);
    switch (index) {
      case 1: //Nome
        tipoObjeto.setType(newValue);
        break;
    }
    tipoObjetoDao.update(tipoObjeto);
    return;
  }

  public void exclude(int id) throws Exception {
    tipoObjetoDao.exclude(id);
  }

  public TipoObjeto getById(int id) {
    List<TipoObjeto> tipoObjetos = tipoObjetoDao.getAll();
    for (TipoObjeto tipoObjeto : tipoObjetos) {
      if (tipoObjeto.getId() == id) return tipoObjeto;
    }
    return null;
  }

  public List<String> getAllData() {
    List<TipoObjeto> tipoObjetos = tipoObjetoDao.getAll();
    List<String> tipoObjetoList = new ArrayList<>();
    tipoObjetoList.add(ID + INDEX_LIST);
    if (tipoObjetos == null) return tipoObjetoList;
    for (TipoObjeto tipoObjeto : tipoObjetos) {
      tipoObjetoList.add(tipoObjeto.getId() + ";" + tipoObjeto.getType());
    }
    return tipoObjetoList;
  }

  public List<String> requestEdit(int id) {
    TipoObjeto tipoObjeto = getById(id);
    List<String> tipoObjetoList = new ArrayList<>();
    if (tipoObjeto == null) return tipoObjetoList;
    tipoObjetoList.add(INDEX_LIST);
    tipoObjetoList.add(tipoObjeto.getType());
    return tipoObjetoList;
  }
}
