package com.model.dao;

import com.model.entity.TipoObjeto;
import java.util.ArrayList;
import java.util.List;

public class TipoObjetoDao {

  List<TipoObjeto> tipoObjetoList = new ArrayList<TipoObjeto>();

  public void insert(TipoObjeto tipoObjeto) {
    this.tipoObjetoList.add(tipoObjeto);
  }

  public void getById(int id) {}

  public List<TipoObjeto> getAll() {
    return this.tipoObjetoList;
  }

  public int getLastIndex() {
    return tipoObjetoList.size();
  }
}
