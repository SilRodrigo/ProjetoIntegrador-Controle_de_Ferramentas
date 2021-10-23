package com.model.dao;

import com.model.entity.Manutencao;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDao {

  List<Manutencao> manutencaoList = new ArrayList<Manutencao>();

  public void insert(Manutencao manutencao) {
    this.manutencaoList.add(manutencao);
  }

  public Manutencao getById(int id) {
    for (Manutencao manutencao : this.manutencaoList) {
      if (manutencao.getId() == id) {
        return manutencao;
      }
    }
    return null;
  }

  public List<Manutencao> getAll() {
    return manutencaoList;
  }

  public int getLastIndex() {
    return manutencaoList.size();
  }
}
