package com.model.service;

import com.model.dao.ObjetoDao;
import com.model.entity.Objeto;
import java.util.ArrayList;
import java.util.List;

public class ObjetoService {

  ObjetoDao objetoDao = new ObjetoDao();

  public void insert(
    String name,
    int objectTypeId,
    boolean borrowed,
    boolean inMaintenance
  ) {
    Objeto objeto = new Objeto(
      objetoDao.getLastIndex() + 1,
      name,
      objectTypeId,
      borrowed,
      inMaintenance
    );
    objetoDao.insert(objeto);
  }

  public void getById(int id) {}

  public List<String> getAllData() {
    List<Objeto> tipoObjetos = objetoDao.getAll();
    List<String> objetoList = new ArrayList<>();
    objetoList.add("id;Tipo;Nome;Emprestado;Em Manutencao");
    if (tipoObjetos == null) return objetoList;
    for (Objeto tipoObjeto : tipoObjetos) {
      objetoList.add(
        tipoObjeto.getId() +
        ";" +
        tipoObjeto.getObjectTypeId() +
        ";" +
        tipoObjeto.getName() +
        ";" +
        (tipoObjeto.isBorrowed() ? "Sim" : "Nao") +
        ";" +
        (tipoObjeto.isInMaintenance() ? "Sim" : "Nao")
      );
    }
    return objetoList;
  }

  public List<String> getAllData(TipoObjetoService tipoObjetoService) {
    List<Objeto> tipoObjetos = objetoDao.getAll();
    List<String> objetoList = new ArrayList<>();
    objetoList.add("id;Tipo;Nome;Emprestado;Em Manutencao");
    if (tipoObjetos == null) return objetoList;
    for (Objeto tipoObjeto : tipoObjetos) {
      objetoList.add(
        tipoObjeto.getId() +
        ";" +
        tipoObjetoService.getById(tipoObjeto.getObjectTypeId()).getType() +
        ";" +
        tipoObjeto.getName() +
        ";" +
        (tipoObjeto.isBorrowed() ? "Sim" : "Nao") +
        ";" +
        (tipoObjeto.isInMaintenance() ? "Sim" : "Nao")
      );
    }
    return objetoList;
  }

  public List<String> getInsertRequiredOnly() {
    List<Objeto> tipoObjetos = objetoDao.getAll();
    List<String> objetoList = new ArrayList<>();
    objetoList.add("id;Tipo;Nome");
    if (tipoObjetos == null) return objetoList;
    for (Objeto tipoObjeto : tipoObjetos) {
      objetoList.add(
        tipoObjeto.getId() +
        ";" +
        tipoObjeto.getObjectTypeId() +
        ";" +
        tipoObjeto.getName()
      );
    }
    return objetoList;
  }
}
