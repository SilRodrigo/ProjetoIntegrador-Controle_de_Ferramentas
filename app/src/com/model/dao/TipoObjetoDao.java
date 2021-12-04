package com.model.dao;

import com.model.entity.TipoObjeto;
import java.util.ArrayList;
import java.util.List;

public class TipoObjetoDao {

  static List<TipoObjeto> tipoObjetoList = new ArrayList<TipoObjeto>();

  public void insert(TipoObjeto tipoObjeto) {
    tipoObjetoList.add(tipoObjeto);
  }

  public boolean update(TipoObjeto tipoObjeto) {
    for (TipoObjeto tipoObjetoOld : TipoObjetoDao.tipoObjetoList) {
      if (tipoObjetoOld.getId() == tipoObjeto.getId()) {
        tipoObjetoOld = tipoObjeto;
        return true;
      }
    }
    return false;
  }

  public void exclude(int id) {
    TipoObjetoDao.tipoObjetoList.remove(this.getById(id));
  }

  public TipoObjeto getById(int id) {
    for (TipoObjeto tipoObjeto : TipoObjetoDao.tipoObjetoList) {
      if (tipoObjeto.getId() == id) {
        return tipoObjeto;
      }
    }
    return null;
  }

  public List<TipoObjeto> getAll() {
    return tipoObjetoList;
  }

  public int getLastIndex() {
    return tipoObjetoList.size();
  }
}
