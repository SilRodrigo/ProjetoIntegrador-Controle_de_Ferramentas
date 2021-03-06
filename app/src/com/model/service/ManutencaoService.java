package com.model.service;

import com.model.dao.ManutencaoDao;
import com.model.entity.Manutencao;
import com.model.entity.Objeto;
import com.util.Texting;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoService {

  ManutencaoDao manutencaoDao = new ManutencaoDao();

  public String insert(String name, int objetoId, boolean status) {
    try {
      Manutencao manutencao = new Manutencao(
        manutencaoDao.getLastIndex() + 1,
        name,
        objetoId,
        status
      );
      ObjetoService objetoService = new ObjetoService();
      Objeto objeto = objetoService.getById(objetoId);
      if (
        !objeto.getStatus() || objeto.isBorrowed() || objeto.isInMaintenance()
      ) throw new Exception(
        "Objeto não pode ir para manutencao.\nVerifique sua situação antes de continuar."
      );
      objeto.setInMaintenance(true);
      objetoService.update(objeto);
      manutencaoDao.insert(manutencao);
      return Texting.registerSuccessful;
    } catch (Exception e) {
      System.out.println(e);
      return Texting.registerFailure;
    }
  }

  public void update(int id, int index, String newValue) throws Exception {
    Manutencao manutencao = getById(id);
    switch (index) {
      case 1: //Status
        newValue = newValue.toUpperCase();
        if (newValue.equals("F") || newValue.equals("FINALIZADO")) {
          manutencao.setStatus(true);
          ObjetoService objetoService = new ObjetoService();
          Objeto objeto = objetoService.getById(manutencao.getObjetoId());
          objeto.setInMaintenance(false);
          objetoService.update(objeto);
        }
      break;
    }
    manutencaoDao.update(manutencao);
    return;
  }

  public void exclude(int id) throws Exception {
    throw new Exception("Exclusão não habilitada para esse módulo");
    /* manutencaoDao.exclude(id); */
  }

  public Manutencao getById(int id) {
    return manutencaoDao.getById(id);
  }

  public List<String> getAllData() {
    List<Manutencao> manutencoes = manutencaoDao.getAll();
    List<String> manutencaoList = new ArrayList<>();
    manutencaoList.add("id;Nome;Objeto;Status");
    if (manutencoes == null) return manutencaoList;
    for (Manutencao manutencao : manutencoes) {
      manutencaoList.add(
        manutencao.getId() +
        ";" +
        manutencao.getName() +
        ";" +
        new ObjetoService().getById(manutencao.getObjetoId()).getName() +
        ";" +
        (manutencao.getStatus() ? "Encerrada" : "Em andamento")
      );
    }
    return manutencaoList;
  }

  public List<String> getInsertRequiredOnly() {
    List<Manutencao> manutencoes = manutencaoDao.getAll();
    List<String> manutencaoList = new ArrayList<>();
    manutencaoList.add("id;Nome;Objeto");
    if (manutencoes == null) return manutencaoList;
    for (Manutencao manutencao : manutencoes) {
      manutencaoList.add(
        manutencao.getId() +
        ";" +
        manutencao.getName() +
        ";" +
        manutencao.getObjetoId()
      );
    }
    return manutencaoList;
  }

  public List<String> requestEdit(int id) {
    Manutencao manutencao = getById(id);
    List<String> manutencaoList = new ArrayList<>();
    if (manutencao == null) return manutencaoList;
    manutencaoList.add("Status ((F)inalizado para encerrar a manutencao)");
    manutencaoList.add((manutencao.getStatus() ? "Encerrada" : "Em andamento"));
    return manutencaoList;
  }
}
