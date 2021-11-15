package com.model.dao;

import com.model.entity.Objeto;
import java.util.ArrayList;
import java.util.List;

public class ObjetoDao {

  static List<Objeto> objetoList = new ArrayList<Objeto>();

  public Objeto getById(int id) {
    for (Objeto objeto : ObjetoDao.objetoList) {
      if (objeto.getId() == id) {
        return objeto;
      }
    }
    return null;
  }

  public int getLastIndex() {
    return objetoList.size();
  }

  public void insert(Objeto objeto) {
    ObjetoDao.objetoList.add(objeto);
  }

  public List<Objeto> getAll() {
    return ObjetoDao.objetoList;
  }

  public void update(Objeto newObjeto) {
    Objeto objeto = this.getById(newObjeto.getId());
    if (objeto == null) return;
    objeto.setName(newObjeto.getName());
    objeto.setBorrowed(newObjeto.isBorrowed());
    objeto.setInMaintenance(newObjeto.isInMaintenance());
    objeto.setObjectTypeId(newObjeto.getObjectTypeId());
    objeto.setStatus(newObjeto.getStatus());
  }

  public List<Objeto> getAvailable() {
    List<Objeto> objetoList = new ArrayList<>();
    for (Objeto objeto : ObjetoDao.objetoList) {
      if (
        objeto.getStatus() && !objeto.isBorrowed() && !objeto.isInMaintenance()
      ) objetoList.add(objeto);
    }
    return objetoList;
  }
}
