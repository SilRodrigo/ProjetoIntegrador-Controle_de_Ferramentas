package com.model.dao;

import com.model.entity.Manutencao;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoDao {

  static List<Manutencao> manutencaoList = new ArrayList<Manutencao>();

  public void insert(Manutencao manutencao) {
    ManutencaoDao.manutencaoList.add(manutencao);
  }

  public boolean update(Manutencao manutencao) {
    for (Manutencao manutencaoOld : ManutencaoDao.manutencaoList) {
      if (manutencaoOld.getId() == manutencao.getId()) {
        manutencaoOld = manutencao;
        return true;
      }
    }
    return false;
  }

  public void exclude(int id) {
    ManutencaoDao.manutencaoList.remove(this.getById(id));
  }

  public Manutencao getById(int id) {
    for (Manutencao manutencao : ManutencaoDao.manutencaoList) {
      if (manutencao.getId() == id) {
        return manutencao;
      }
    }
    return null;
  }

  public List<Manutencao> getAll() {
    return ManutencaoDao.manutencaoList;
  }

  public int getLastIndex() {
    return ManutencaoDao.manutencaoList.size();
  }
}
