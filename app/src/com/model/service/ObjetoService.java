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

  public void update(int id, int index, String newValue) throws Exception {
    Objeto objeto = getById(id);
    switch (index) {
      case 1: //Nome
        objeto.setName(newValue);
      case 2: //Status;
        newValue = newValue.toUpperCase();
        if (newValue.equals("A") || newValue.equals("ATIVO")) objeto.setStatus(
          true
        );
        if (newValue.equals("I") || newValue.equals("INATIVO")) {
          if (
            objeto.isBorrowed() || objeto.isInMaintenance()
          ) throw new Exception(); else objeto.setStatus(false);
        }
      default:
        objetoDao.update(objeto);
    }
    return;
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

  private List<String> toStringList(
    List<Objeto> objetos,
    TipoObjetoService tipoObjetoService
  ) {
    List<String> objetoList = new ArrayList<>();
    objetoList.add("id;Tipo;Nome;Emprestado;Em Manutencao;Status");
    if (objetos == null) return objetoList;
    for (Objeto objeto : objetos) {
      objetoList.add(
        objeto.getId() +
        ";" +
        tipoObjetoService.getById(objeto.getObjectTypeId()).getType() +
        ";" +
        objeto.getName() +
        ";" +
        (objeto.isBorrowed() ? "Sim" : "Nao") +
        ";" +
        (objeto.isInMaintenance() ? "Sim" : "Nao") +
        ";" +
        (objeto.getStatus() ? "Ativo" : "Inativo")
      );
    }
    return objetoList;
  }

  public List<String> requestEdit(int id) {
    Objeto objeto = getById(id);
    List<String> objetoList = new ArrayList<>();
    if (objeto == null) return objetoList;
    objetoList.add("Nome;Status (Digite (A)tivo ou (I)nativo para alterar)");
    objetoList.add(
      objeto.getName() + ";" + (objeto.getStatus() ? "Ativo" : "Inativo")
    );
    return objetoList;
  }
}
