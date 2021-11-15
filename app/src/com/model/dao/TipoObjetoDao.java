package com.model.dao;

import com.model.entity.TipoObjeto;
import java.util.ArrayList;
import java.util.List;

public class TipoObjetoDao {

  static List<TipoObjeto> tipoObjetoList = new ArrayList<TipoObjeto>();

  public void insert(TipoObjeto tipoObjeto) {
    tipoObjetoList.add(tipoObjeto);
  }

  public void getById(int id) {}

  public List<TipoObjeto> getAll() {
    return tipoObjetoList;
  }

  public int getLastIndex() {
    return tipoObjetoList.size();
  }
}
