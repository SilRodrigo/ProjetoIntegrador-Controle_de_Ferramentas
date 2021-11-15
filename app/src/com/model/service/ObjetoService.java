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
    boolean inMaintenance,
    boolean status
  ) {
    Objeto objeto = new Objeto(
      objetoDao.getLastIndex() + 1,
      name,
      objectTypeId,
      borrowed,
      inMaintenance,
      status
    );
    objetoDao.insert(objeto);
  }

  public Objeto getById(int id) {
    return objetoDao.getById(id);
  }

  public List<String> getAllData() {
    List<Objeto> objetos = objetoDao.getAll();
    return toStringList(objetos, new TipoObjetoService());
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

  public List<String> getAvailable() {
    List<Objeto> objetos = this.objetoDao.getAvailable();
    return toStringList(objetos, new TipoObjetoService());
  }

  public void update(Objeto objeto) {
    this.objetoDao.update(objeto);
  }

  private List<String> toStringList(List<Objeto> objetos, TipoObjetoService tipoObjetoService) {
    List<String> objetoList = new ArrayList<>();
    objetoList.add("id;Tipo;Nome;Emprestado;Em Manutencao;Status");
    if (objetos == null) return objetoList;
    for (Objeto tipoObjeto : objetos) {
      objetoList.add(
        tipoObjeto.getId() +
        ";" +
        tipoObjetoService.getById(tipoObjeto.getObjectTypeId()).getType() +
        ";" +
        tipoObjeto.getName() +
        ";" +
        (tipoObjeto.isBorrowed() ? "Sim" : "Nao") +
        ";" +
        (tipoObjeto.isInMaintenance() ? "Sim" : "Nao") +
        ";" +
        (tipoObjeto.getStatus() ? "Ativo" : "Inativo")
      );
    }
    return objetoList;
  }
}
