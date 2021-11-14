package com.model.dao;

import com.model.entity.Objeto;
import java.util.ArrayList;
import java.util.List;

public class ObjetoDao {

  List<Objeto> objetoList = new ArrayList<Objeto>();

  public Objeto getById(int id) {
    for (Objeto objeto : this.objetoList) {
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
    this.objetoList.add(objeto);
  }

  public List<Objeto> getAll() {
    return this.objetoList;
  }
}
