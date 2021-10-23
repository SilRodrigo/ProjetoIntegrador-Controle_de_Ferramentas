package com.model.service;

import com.model.dao.ManutencaoDao;
import com.model.entity.Manutencao;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoService {

  ManutencaoDao manutencaoDao = new ManutencaoDao();

  public void insert(String name) {
    Manutencao manutencao = new Manutencao(
      manutencaoDao.getLastIndex() + 1,
      name
    );
    manutencaoDao.insert(manutencao);
  }

  public Manutencao getById(int id) {
    return manutencaoDao.getById(id);
  }

  public List<String> getAllData() {
    List<Manutencao> manutencoes = manutencaoDao.getAll();
    List<String> manutencaoList = new ArrayList<>();
    manutencaoList.add("id;Nome");
    if (manutencoes == null) return manutencaoList;
    for (Manutencao manutencao : manutencoes) {
      manutencaoList.add(manutencao.getId() + ";" + manutencao.getName());
    }
    return manutencaoList;
  }
}
